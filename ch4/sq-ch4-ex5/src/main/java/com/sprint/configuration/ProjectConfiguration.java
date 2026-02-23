package com.sprint.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.sprint.proxies", "com.sprint.repositories", "com.sprint.services"})
@Configuration
public class ProjectConfiguration {
}
