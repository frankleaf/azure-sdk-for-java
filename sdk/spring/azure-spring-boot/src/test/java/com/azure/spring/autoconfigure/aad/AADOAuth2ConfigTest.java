// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.autoconfigure.aad;

import com.azure.spring.aad.implementation.AzureActiveDirectoryAutoConfiguration;
import com.azure.spring.aad.implementation.AzureClientRegistrationRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.mock.env.MockPropertySource;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class AADOAuth2ConfigTest {
    private static final String AAD_OAUTH2_MINIMUM_PROPS = "aad-backend-oauth2-minimum.properties";
    private Resource testResource;
    private ResourcePropertySource testPropResource;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    private AnnotationConfigWebApplicationContext testContext;

    @Before
    public void setup() throws Exception {
        testResource = new ClassPathResource(AAD_OAUTH2_MINIMUM_PROPS);
        testPropResource = new ResourcePropertySource("test", testResource);
    }

    @After
    public void clear() {
        if (testContext != null) {
            testContext.close();
        }
    }

    @Test
    public void noOAuth2UserServiceBeanCreatedIfPropsNotConfigured() {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AzureActiveDirectoryAutoConfiguration.class);
        context.refresh();

        exception.expect(NoSuchBeanDefinitionException.class);
        context.getBean(OAuth2UserService.class);
    }

    @Test
    public void testOAuth2UserServiceBeanCreatedIfPropsConfigured() {
        testContext = initTestContext();
        Assert.assertNotNull(testContext.getBean(OAuth2UserService.class));
    }

    @Test
    public void noOAuth2UserServiceBeanCreatedIfTenantIdNotConfigured() {
        testPropResource.getSource().remove(TestConstants.TENANT_ID_PROPERTY);
        testContext = initTestContext();

        exception.expect(NoSuchBeanDefinitionException.class);
        testContext.getBean(OAuth2UserService.class);
    }

    @Test
    public void testEndpointsPropertiesLoadAndOverridable() {
        testContext = initTestContext("azure.service.endpoints.global.aadKeyDiscoveryUri=https://test/",
            "azure.service.endpoints.global.aadSigninUri=https://test/",
            "azure.service.endpoints.global.aadGraphApiUri=https://test/",
            "azure.service.endpoints.global.aadKeyDiscoveryUri=https://test/",
            "azure.service.endpoints.global.aadMembershipRestUri=https://test/",
            TestConstants.ALLOW_TELEMETRY_PROPERTY + "=false");


        final Environment environment = testContext.getEnvironment();
        assertThat(environment.getProperty("azure.service.endpoints.global.aadSigninUri"))
            .isEqualTo("https://test/");
        assertThat(environment.getProperty("azure.service.endpoints.global.aadGraphApiUri"))
            .isEqualTo("https://test/");
        assertThat(environment.getProperty("azure.service.endpoints.global.aadKeyDiscoveryUri"))
            .isEqualTo("https://test/");
        assertThat(environment.getProperty("azure.service.endpoints.global.aadMembershipRestUri"))
            .isEqualTo("https://test/");
        final ServiceEndpointsProperties serviceEndpointsProperties =
            testContext.getBean(ServiceEndpointsProperties.class);
        assertThat(serviceEndpointsProperties).isNotNull();
        assertThat(serviceEndpointsProperties.getEndpoints()).isNotEmpty();

        final Map<String, ServiceEndpoints> endpoints = serviceEndpointsProperties.getEndpoints();
        assertThat(endpoints).hasSize(4);
        assertThat(endpoints.get("cn")).isNotNull()
                                       .extracting(ServiceEndpoints::getAadGraphApiUri,
                                           ServiceEndpoints::getAadKeyDiscoveryUri,
                                           ServiceEndpoints::getAadMembershipRestUri, ServiceEndpoints::getAadSigninUri)
                                       .containsExactly("https://graph.chinacloudapi.cn/",
                                           "https://login.partner.microsoftonline.cn/common/discovery/keys",
                                           "https://graph.chinacloudapi.cn/me/memberOf?api-version=1.6",
                                           "https://login.partner.microsoftonline.cn/");
        assertThat(endpoints.get("global")).isNotNull()
                                           .extracting(ServiceEndpoints::getAadGraphApiUri,
                                               ServiceEndpoints::getAadKeyDiscoveryUri,
                                               ServiceEndpoints::getAadMembershipRestUri,
                                               ServiceEndpoints::getAadSigninUri)
                                           .containsExactly("https://test/", "https://test/", "https://test/", "https"
                                               + "://test/");

    }

    @Test
    public void testScopePropertyConfiguredWithDynamicPermissions() {
        testContext = initTestContext("azure.activedirectory.authorization.graph.scope=email");
        final Environment environment = testContext.getEnvironment();
        assertThat(environment.getProperty("azure.activedirectory.authorization.graph.scope")).isEqualTo("email");

        final AzureClientRegistrationRepository azureClientRegistrationRepository =
            testContext.getBean(AzureClientRegistrationRepository.class);
        final ClientRegistration clientRegistration = azureClientRegistrationRepository.findByRegistrationId("azure");
        final Set<String> actualScopes = clientRegistration.getScopes();
        final Set<String> expectedScopes = new HashSet<>(Arrays.asList("openid", "profile", "offline_access", "email"));
        assertEquals(expectedScopes, actualScopes);
    }

    @Test
    public void testScopePropertyConfiguredWithStaticPermissions() {
        testContext = initTestContext("azure.activedirectory.authorization.graph.scope=1111/.default");
        final Environment environment = testContext.getEnvironment();
        assertThat(environment.getProperty("azure.activedirectory.authorization.graph.scope")).isEqualTo("1111/"
            + ".default");

        final AzureClientRegistrationRepository azureClientRegistrationRepository =
            testContext.getBean(AzureClientRegistrationRepository.class);
        final ClientRegistration clientRegistration = azureClientRegistrationRepository.findByRegistrationId("azure");
        final Set<String> actualScopes = clientRegistration.getScopes();
        final Set<String> expectedScopes =
            new HashSet<>(Arrays.asList("openid", "profile", "offline_access", "1111/.default"));
        assertEquals(expectedScopes, actualScopes);

        final ClientRegistration graphClientRegistration =
            azureClientRegistrationRepository.findByRegistrationId("graph");
        final Set<String> graphActualScopes = graphClientRegistration.getScopes();
        final Set<String> graphExpectedScopes = new HashSet<>(Collections.singletonList("1111/.default"));
        assertEquals(graphExpectedScopes, graphActualScopes);
    }

    private AnnotationConfigWebApplicationContext initTestContext(String... environment) {
        final AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();

        context.getEnvironment().getPropertySources().addLast(testPropResource);
        context.getEnvironment().getPropertySources().addLast(new MockPropertySource()
            .withProperty(TestConstants.ALLOW_TELEMETRY_PROPERTY, "false"));
        if (environment.length > 0) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(context, environment);
        }

        context.register(AzureActiveDirectoryAutoConfiguration.class);
        context.refresh();

        return context;
    }
}
