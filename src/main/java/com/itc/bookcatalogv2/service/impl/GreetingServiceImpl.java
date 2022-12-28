package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.config.ApplicationProperties;
import com.itc.bookcatalogv2.service.GreetingService;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final ApplicationProperties applicationProperties;

    public GreetingServiceImpl(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    @Override
    public String sayGreeting() {
        TimeZone timezone = TimeZone.getTimeZone(applicationProperties.getTimezone());
        return applicationProperties.getWelcomeText() + " , our timezone: " + timezone.getDisplayName() +
                ", our currency: " + applicationProperties.getCurrency();
    }
}
