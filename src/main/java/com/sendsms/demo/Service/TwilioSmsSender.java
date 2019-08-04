package com.sendsms.demo.Service;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.sendsms.demo.entity.SmsRequest;
import com.sendsms.demo.SmsSender;
import com.sendsms.demo.config.TwilioConfiguration;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gkumbar on 8/3/19
 */

@Service("twilio")
public class TwilioSmsSender implements SmsSender {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioSmsSender.class);

    private static String PHONE_NUMBER_REGEX = "(^1\\d{10}$)|(^+861\\d{10}$)";
    private static String SHORT_PHONE_NUMBER_REGEX = "^1\\d{10}$";
    private static PhoneNumberUtil PN_Util = PhoneNumberUtil.getInstance();


    private final TwilioConfiguration twilioConfiguration;

    @Autowired
    public TwilioSmsSender(TwilioConfiguration twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }


    @Override
    public void sendSms(SmsRequest smsRequest) {
        if(isPhoneNumberValid(smsRequest.getPhoneNumber()))
        {
            PhoneNumber to =new PhoneNumber(smsRequest.getPhoneNumber());
            PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
            String message = smsRequest.getMessage();
            MessageCreator creator = Message.creator(to, from, message);
            creator.create();
            LOGGER.info("Send sms "+ smsRequest);

        }else
        {
            throw new IllegalArgumentException(
                    "Phone number ["+smsRequest.getPhoneNumber()+ "] is not a valid phone number");
        }


    }

    private boolean isPhoneNumberValid(String number) {
        //TODO : use Google library to validate phone number and implement
        return true;
    }
}
