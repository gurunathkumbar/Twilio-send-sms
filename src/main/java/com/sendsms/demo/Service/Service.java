package com.sendsms.demo.Service;

import com.sendsms.demo.entity.SmsRequest;
import com.sendsms.demo.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author gkumbar on 8/3/19
 */

@org.springframework.stereotype.Service
public class Service {

    private final SmsSender smsSender;

    @Autowired
    public Service(@Qualifier("twilio") TwilioSmsSender twilioSmsSender) {
        this.smsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
