package com.sendsms.demo;

import com.sendsms.demo.entity.SmsRequest;

/**
 * @author gkumbar on 8/3/19
 */
public interface SmsSender {

    void sendSms(SmsRequest smsRequest);
}
