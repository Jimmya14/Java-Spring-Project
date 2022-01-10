package com.microservice.message.source.messagesource;

import org.springframework.web.bind.annotation.RestController;

import java.rmi.server.ObjID;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class MessageSourceController {

    @Autowired
    private MessageSource messageSource;
    
    @GetMapping("/{key}")
    public String getMessageByKey(@PathVariable String key) {
        return messageSource.getMessage(key, new ObjID[]{}, Locale.ENGLISH);
    }
    
}
