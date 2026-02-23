package com.sprint.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.sprint.repositories", "com.sprint.proxies", "com.sprint.services"})
@Configuration
public class ProjectConfiguration {


}
