package com.sendsms.demo.Controller;

import com.sendsms.demo.Service.Service;
import com.sendsms.demo.entity.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author gkumbar on 8/3/19
 */

@RestController
@RequestMapping("/api/v1/sms")
public class TwilioController {

    private final Service service;

    @Autowired
    public TwilioController(Service service) {

        this.service = service;
    }

    @PostMapping("/send")
    public void sendSms(@Valid  @RequestBody SmsRequest smsRequest){
        service.sendSms(smsRequest);

    }
}
