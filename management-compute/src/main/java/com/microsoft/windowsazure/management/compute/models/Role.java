/**
 * 
 * Copyright (c) Microsoft and contributors.  All rights reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * 
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

// Warning: This code was generated by a tool.
// 
// Changes to this file may cause incorrect behavior and will be lost if the
// code is regenerated.

package com.microsoft.windowsazure.management.compute.models;

import com.microsoft.windowsazure.core.LazyArrayList;
import java.net.URI;
import java.util.ArrayList;

/**
* Details of a role in a deployment.
*/
public class Role {
    private String availabilitySetName;
    
    /**
    * Optional. The name of the role.
    * @return The AvailabilitySetName value.
    */
    public String getAvailabilitySetName() {
        return this.availabilitySetName;
    }
    
    /**
    * Optional. The name of the role.
    * @param availabilitySetNameValue The AvailabilitySetName value.
    */
    public void setAvailabilitySetName(final String availabilitySetNameValue) {
        this.availabilitySetName = availabilitySetNameValue;
    }
    
    private ArrayList<ConfigurationSet> configurationSets;
    
    /**
    * Optional. A collection of values that represents system or application
    * configuration settings.
    * @return The ConfigurationSets value.
    */
    public ArrayList<ConfigurationSet> getConfigurationSets() {
        return this.configurationSets;
    }
    
    /**
    * Optional. A collection of values that represents system or application
    * configuration settings.
    * @param configurationSetsValue The ConfigurationSets value.
    */
    public void setConfigurationSets(final ArrayList<ConfigurationSet> configurationSetsValue) {
        this.configurationSets = configurationSetsValue;
    }
    
    private ArrayList<DataVirtualHardDisk> dataVirtualHardDisks;
    
    /**
    * Optional. Contains the parameters Azure uses to create a data disk for a
    * virtual machine.
    * @return The DataVirtualHardDisks value.
    */
    public ArrayList<DataVirtualHardDisk> getDataVirtualHardDisks() {
        return this.dataVirtualHardDisks;
    }
    
    /**
    * Optional. Contains the parameters Azure uses to create a data disk for a
    * virtual machine.
    * @param dataVirtualHardDisksValue The DataVirtualHardDisks value.
    */
    public void setDataVirtualHardDisks(final ArrayList<DataVirtualHardDisk> dataVirtualHardDisksValue) {
        this.dataVirtualHardDisks = dataVirtualHardDisksValue;
    }
    
    private String defaultWinRmCertificateThumbprint;
    
    /**
    * Optional. The read-only thumbprint of the certificate that is used with
    * the HTTPS listener for WinRM.
    * @return The DefaultWinRmCertificateThumbprint value.
    */
    public String getDefaultWinRmCertificateThumbprint() {
        return this.defaultWinRmCertificateThumbprint;
    }
    
    /**
    * Optional. The read-only thumbprint of the certificate that is used with
    * the HTTPS listener for WinRM.
    * @param defaultWinRmCertificateThumbprintValue The
    * DefaultWinRmCertificateThumbprint value.
    */
    public void setDefaultWinRmCertificateThumbprint(final String defaultWinRmCertificateThumbprintValue) {
        this.defaultWinRmCertificateThumbprint = defaultWinRmCertificateThumbprintValue;
    }
    
    private String label;
    
    /**
    * Optional. The friendly name for the role.
    * @return The Label value.
    */
    public String getLabel() {
        return this.label;
    }
    
    /**
    * Optional. The friendly name for the role.
    * @param labelValue The Label value.
    */
    public void setLabel(final String labelValue) {
        this.label = labelValue;
    }
    
    private URI mediaLocation;
    
    /**
    * Optional. Storage location where the VM Image VHDs should be copied, for
    * published VM Images.
    * @return The MediaLocation value.
    */
    public URI getMediaLocation() {
        return this.mediaLocation;
    }
    
    /**
    * Optional. Storage location where the VM Image VHDs should be copied, for
    * published VM Images.
    * @param mediaLocationValue The MediaLocation value.
    */
    public void setMediaLocation(final URI mediaLocationValue) {
        this.mediaLocation = mediaLocationValue;
    }
    
    private String oSVersion;
    
    /**
    * Optional. The version of the operating system on which the role instances
    * are running.
    * @return The OSVersion value.
    */
    public String getOSVersion() {
        return this.oSVersion;
    }
    
    /**
    * Optional. The version of the operating system on which the role instances
    * are running.
    * @param oSVersionValue The OSVersion value.
    */
    public void setOSVersion(final String oSVersionValue) {
        this.oSVersion = oSVersionValue;
    }
    
    private OSVirtualHardDisk oSVirtualHardDisk;
    
    /**
    * Optional. Contains the parameters Azure uses to create the operating
    * system disk for the virtual machine.
    * @return The OSVirtualHardDisk value.
    */
    public OSVirtualHardDisk getOSVirtualHardDisk() {
        return this.oSVirtualHardDisk;
    }
    
    /**
    * Optional. Contains the parameters Azure uses to create the operating
    * system disk for the virtual machine.
    * @param oSVirtualHardDiskValue The OSVirtualHardDisk value.
    */
    public void setOSVirtualHardDisk(final OSVirtualHardDisk oSVirtualHardDiskValue) {
        this.oSVirtualHardDisk = oSVirtualHardDiskValue;
    }
    
    private Boolean provisionGuestAgent;
    
    /**
    * Optional. Indicates whether the WindowsAzureGuestAgent service is
    * installed on the Virtual Machine. To run a resource extension in a
    * Virtual Machine, this service must be installed.
    * @return The ProvisionGuestAgent value.
    */
    public Boolean isProvisionGuestAgent() {
        return this.provisionGuestAgent;
    }
    
    /**
    * Optional. Indicates whether the WindowsAzureGuestAgent service is
    * installed on the Virtual Machine. To run a resource extension in a
    * Virtual Machine, this service must be installed.
    * @param provisionGuestAgentValue The ProvisionGuestAgent value.
    */
    public void setProvisionGuestAgent(final Boolean provisionGuestAgentValue) {
        this.provisionGuestAgent = provisionGuestAgentValue;
    }
    
    private ArrayList<ResourceExtensionReference> resourceExtensionReferences;
    
    /**
    * Optional. Contains a collection of resource extensions that are to be
    * installed on the Virtual Machine. This element is used if
    * ProvisionGuestAgent is set to true.
    * @return The ResourceExtensionReferences value.
    */
    public ArrayList<ResourceExtensionReference> getResourceExtensionReferences() {
        return this.resourceExtensionReferences;
    }
    
    /**
    * Optional. Contains a collection of resource extensions that are to be
    * installed on the Virtual Machine. This element is used if
    * ProvisionGuestAgent is set to true.
    * @param resourceExtensionReferencesValue The ResourceExtensionReferences
    * value.
    */
    public void setResourceExtensionReferences(final ArrayList<ResourceExtensionReference> resourceExtensionReferencesValue) {
        this.resourceExtensionReferences = resourceExtensionReferencesValue;
    }
    
    private String roleName;
    
    /**
    * Optional. The name of the role.
    * @return The RoleName value.
    */
    public String getRoleName() {
        return this.roleName;
    }
    
    /**
    * Optional. The name of the role.
    * @param roleNameValue The RoleName value.
    */
    public void setRoleName(final String roleNameValue) {
        this.roleName = roleNameValue;
    }
    
    private String roleSize;
    
    /**
    * Optional. The size of the role instance.
    * @return The RoleSize value.
    */
    public String getRoleSize() {
        return this.roleSize;
    }
    
    /**
    * Optional. The size of the role instance.
    * @param roleSizeValue The RoleSize value.
    */
    public void setRoleSize(final String roleSizeValue) {
        this.roleSize = roleSizeValue;
    }
    
    private String roleType;
    
    /**
    * Optional. Specifies the type of the role. This element is only listed for
    * Virtual Machine deployments, and by default is PersistentVMRole.
    * @return The RoleType value.
    */
    public String getRoleType() {
        return this.roleType;
    }
    
    /**
    * Optional. Specifies the type of the role. This element is only listed for
    * Virtual Machine deployments, and by default is PersistentVMRole.
    * @param roleTypeValue The RoleType value.
    */
    public void setRoleType(final String roleTypeValue) {
        this.roleType = roleTypeValue;
    }
    
    private String vMImageName;
    
    /**
    * Optional. Optional. The name of the VMImage from which this Role is to be
    * created. If the OSDisk in the VMImage was Specialized, then no
    * WindowsProvisioningConfigurationSet or LinuxProvisioningConfigurationSet
    * should be provided. No OSVirtualHardDisk or DataVirtualHardDisk should
    * be specified when using this argument.
    * @return The VMImageName value.
    */
    public String getVMImageName() {
        return this.vMImageName;
    }
    
    /**
    * Optional. Optional. The name of the VMImage from which this Role is to be
    * created. If the OSDisk in the VMImage was Specialized, then no
    * WindowsProvisioningConfigurationSet or LinuxProvisioningConfigurationSet
    * should be provided. No OSVirtualHardDisk or DataVirtualHardDisk should
    * be specified when using this argument.
    * @param vMImageNameValue The VMImageName value.
    */
    public void setVMImageName(final String vMImageNameValue) {
        this.vMImageName = vMImageNameValue;
    }
    
    /**
    * Initializes a new instance of the Role class.
    *
    */
    public Role() {
        this.setConfigurationSets(new LazyArrayList<ConfigurationSet>());
        this.setDataVirtualHardDisks(new LazyArrayList<DataVirtualHardDisk>());
        this.setResourceExtensionReferences(new LazyArrayList<ResourceExtensionReference>());
    }
}
