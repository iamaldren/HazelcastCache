package com.aldren.handler;

import com.aldren.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class ShutdownCallbackHandler {

    @Autowired
    private StudentService service;

    @PreDestroy
    public void destroy() {
        System.out.println("Executing shutdown callback for eviciting cache records...");
        service.evictAllCacheValues();
    }

}
