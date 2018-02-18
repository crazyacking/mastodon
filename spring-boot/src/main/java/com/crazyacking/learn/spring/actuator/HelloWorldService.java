package com.crazyacking.learn.spring.actuator;

/**
 * @author shanbiao.jsb
 * @date 2018/2/8
 */

import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {

    private final ServiceProperties configuration;

    public HelloWorldService(ServiceProperties configuration) {
        this.configuration = configuration;
    }

    public String getHelloMessage() {
        return "Hello " + this.configuration.getName();
    }

}
