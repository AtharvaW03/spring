package com.sprint.sqch11ex1.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.sprint")
/*
@EnableFeignClients enables openfeign functionality
and tells OpenFeign where to search for the client contracts
 */
public class ProjectConfig {
}
