package com.crazyacking.learn.spring.actuator;

/**
 * @author shanbiao.jsb
 * @date 2018/2/8
 */

import java.util.Collections;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class ExampleInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("example", Collections.singletonMap("someKey", "someValue"));
    }

}
