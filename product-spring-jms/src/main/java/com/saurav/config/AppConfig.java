package com.saurav.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="com.saurav")
@Import({MessageConfiguration.class})
public class AppConfig {

}
