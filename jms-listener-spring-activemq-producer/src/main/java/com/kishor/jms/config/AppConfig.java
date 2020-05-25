package com.kishor.jms.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages="com.kishor.jms")
@Import({MessagingConfiguration.class})
public class AppConfig {

}
