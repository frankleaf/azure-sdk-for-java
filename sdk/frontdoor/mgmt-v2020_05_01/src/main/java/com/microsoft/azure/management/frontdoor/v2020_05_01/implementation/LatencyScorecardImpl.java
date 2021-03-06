/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01.implementation;

import com.microsoft.azure.management.frontdoor.v2020_05_01.LatencyScorecard;
import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import org.joda.time.DateTime;
import java.util.List;
import com.microsoft.azure.management.frontdoor.v2020_05_01.LatencyMetric;
import java.util.Map;

class LatencyScorecardImpl extends WrapperImpl<LatencyScorecardInner> implements LatencyScorecard {
    private final NetworkManager manager;
    LatencyScorecardImpl(LatencyScorecardInner inner, NetworkManager manager) {
        super(inner);
        this.manager = manager;
    }

    @Override
    public NetworkManager manager() {
        return this.manager;
    }

    @Override
    public String country() {
        return this.inner().country();
    }

    @Override
    public String description() {
        return this.inner().description();
    }

    @Override
    public DateTime endDateTimeUTC() {
        return this.inner().endDateTimeUTC();
    }

    @Override
    public String endpointA() {
        return this.inner().endpointA();
    }

    @Override
    public String endpointB() {
        return this.inner().endpointB();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public List<LatencyMetric> latencyMetrics() {
        return this.inner().latencyMetrics();
    }

    @Override
    public String latencyScorecardId() {
        return this.inner().latencyScorecardId();
    }

    @Override
    public String latencyScorecardName() {
        return this.inner().latencyScorecardName();
    }

    @Override
    public String location() {
        return this.inner().location();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public DateTime startDateTimeUTC() {
        return this.inner().startDateTimeUTC();
    }

    @Override
    public Map<String, String> tags() {
        return this.inner().getTags();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

}
