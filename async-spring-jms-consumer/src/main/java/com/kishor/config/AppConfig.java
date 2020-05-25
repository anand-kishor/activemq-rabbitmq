package com.kishor.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="com.kishor")
@Import({MessagingConfiguration.class})
public class AppConfig {

}
