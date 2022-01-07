package com.springboot.mongo.demo.project.Messages;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongo.demo.project.Global.MessageResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/message")
public class MessageSourceController {

    @Autowired
    MessageSourceClient messageSourceClient;
    
    @GetMapping(value="/{key}")
    public MessageResponse getMessage(@PathVariable String key) {
        return new MessageResponse(messageSourceClient.getMessageByKey(key));
    }
    
}
