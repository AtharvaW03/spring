package com.sprint.projectconfig;

import com.sprint.service.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    @Bean
    public CommentService commentService(){
        return new CommentService();
    }
}
