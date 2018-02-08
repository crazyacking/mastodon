package com.crazyacking.learn.spring.actuator;

/**
 * @author shanbiao.jsb
 * @date 2018/2/8
 */

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ExampleHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("counter", 42).build();
    }

}
