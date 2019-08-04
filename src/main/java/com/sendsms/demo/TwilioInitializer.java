package com.sendsms.demo;

import com.sendsms.demo.config.TwilioConfiguration;
import com.twilio.Twilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author gkumbar on 8/3/19
 */

@Configuration
public class TwilioInitializer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioInitializer.class);

    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioInitializer(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        LOGGER.info("Twilio initialized....with account sid {}", twilioConfiguration.getAccountSid());
    }
}
