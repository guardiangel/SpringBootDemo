package com.felix.springbootdemo;

import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Duration;

public class SpringBootDemoRunLister implements SpringApplicationRunListener {

    private final SpringApplication springApplication;

    private final String[] args;

    public SpringBootDemoRunLister(SpringApplication springApplication, String[] args) {
        this.springApplication = springApplication;
        this.args = args;
    }

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        System.err.println(">>>>>>>>>The service is starting......>>>>>>>>>>>");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        System.err.println(">>>>>>>>>The service started and prepare to provide service......>>>>>>>>>>>");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.err.println(">>>>>>>>>The service failed to start, the reason is:"+exception.getLocalizedMessage()+"......>>>>>>>>>>>");
    }
}
