package com.felix.springbootdemo;

import org.owasp.esapi.ESAPI;
import org.owasp.esapi.Logger;
import org.springframework.boot.ConfigurableBootstrapContext;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Duration;

public class SpringBootDemoRunLister implements SpringApplicationRunListener {
    private final Logger log = ESAPI.getLogger(SpringBootDemoRunLister.class);

    @Override
    public void starting(ConfigurableBootstrapContext bootstrapContext) {
        log.info(Logger.EVENT_UNSPECIFIED,">>>>>>>>>The service is starting......>>>>>>>>>>>");
    }

    @Override
    public void started(ConfigurableApplicationContext context, Duration timeTaken) {
        log.info(Logger.EVENT_SUCCESS,">>>>>>>>>The service started and prepare to provide service......>>>>>>>>>>>");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.error(Logger.EVENT_FAILURE,">>>>>>>>>The service failed to start, the reason is:"+exception.getLocalizedMessage()+"......>>>>>>>>>>>");
    }
}
