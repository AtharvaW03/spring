package com.sprint.configuration;

import com.sprint.proxies.CommentNotificationProxy;
import com.sprint.proxies.EmailCommentNotificationProxy;
import com.sprint.repositories.CommentRepository;
import com.sprint.repositories.DBCommentRepository;
import com.sprint.services.CommentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfiguration {
    @Bean
    public CommentRepository commentRepository(){
        return new DBCommentRepository();
    }

    @Bean
    public CommentNotificationProxy commentNotificationProxy(){
        return new EmailCommentNotificationProxy();
    }

    @Bean
    public CommentService commentService(CommentRepository commentRepository, CommentNotificationProxy commentNotificationProxy){
        return new CommentService(commentRepository, commentNotificationProxy);
    }


}
