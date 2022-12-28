package com.itc.bookcatalogv2.service.impl;

import com.itc.bookcatalogv2.config.ApplicationProperties;
import com.itc.bookcatalogv2.config.CloudProperties;
import com.itc.bookcatalogv2.service.GreetingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.TimeZone;

@Service
public class GreetingServiceImpl implements GreetingService {

    Logger log = LoggerFactory.getLogger(GreetingServiceImpl.class);

    private final ApplicationProperties applicationProperties;

    private final CloudProperties cloudProperties;

    public GreetingServiceImpl(ApplicationProperties applicationProperties, CloudProperties cloudProperties) {
        this.applicationProperties = applicationProperties;
        this.cloudProperties = cloudProperties;
    }

    @Override
    public String sayGreeting() {
        log.trace("this is log TRACE");
        log.debug("this is log DEBUG");
        log.info("this is log INFO");
        log.warn("this is log WARN");
        log.error("this is log ERROR");
        System.out.println(cloudProperties.getApiKey());
        TimeZone timezone = TimeZone.getTimeZone(applicationProperties.getTimezone());
        return applicationProperties.getWelcomeText() + " , our timezone: " + timezone.getDisplayName() +
                ", our currency: " + applicationProperties.getCurrency();
    }
}
