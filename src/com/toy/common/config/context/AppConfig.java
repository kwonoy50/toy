package com.toy.common.config.context;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan(
        useDefaultFilters = false,
        basePackages   = "com.toy",
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.ASPECTJ, pattern = "*..common.config.context.*"),
                @ComponentScan.Filter({ Service.class, Repository.class, Component.class }),
        })
public class AppConfig {

}
