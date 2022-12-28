package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.config.ApplicationProperties;
import com.itc.bookcatalogv2.config.CloudProperties;
import com.itc.bookcatalogv2.service.GreetingService;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final ApplicationProperties applicationProperties;

    private final CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties applicationProperties, CloudProperties cloudProperties) {
        this.applicationProperties = applicationProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        System.out.println(cloudProperties.getApiKey());
        TimeZone timezone = TimeZone.getTimeZone(applicationProperties.getTimezone());
        return applicationProperties.getWelcomeText() + " , our timezone: " + timezone.getDisplayName() +
                ", our currency: " + applicationProperties.getCurrency();
    }
}
