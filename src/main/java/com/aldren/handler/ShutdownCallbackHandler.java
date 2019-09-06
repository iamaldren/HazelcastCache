package com.aldren.handler;

import com.aldren.service.StudentService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShutdownCallbackHandler implements DisposableBean {

    @Autowired
    private StudentService service;

    @Override
    public void destroy() throws Exception {
        System.out.println("Executing shutdown callback for eviciting cache records...");
        service.evictAllCacheValues();
    }

}
