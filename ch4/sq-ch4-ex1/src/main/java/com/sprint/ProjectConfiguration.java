package com.sprint;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sprint.proxies", "com.sprint.services", "com.sprint.repositories"})
public class ProjectConfiguration {
}
