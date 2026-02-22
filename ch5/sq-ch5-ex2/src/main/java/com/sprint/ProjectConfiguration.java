package com.sprint;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.sprint.repository", "com.sprint.services"})
public class ProjectConfiguration {
}
