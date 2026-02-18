package com.sprint.main;

import com.sprint.ProjectConfiguration;
import com.sprint.model.Comment;
import com.sprint.proxies.EmailCommentNotificationProxy;
import com.sprint.repositories.DBCommentRepository;
import com.sprint.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {
    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Atharva");
        comment.setText("Testing comment with spring!!");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}