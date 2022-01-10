package com.springboot.mongo.demo.project.messages;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value="messageSource", url="localhost:8081")
public interface MessageSourceClient {
    
    @GetMapping("/{key}")
    String getMessageByKey(@PathVariable String key);

}
