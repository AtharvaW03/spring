package com.sprint.main;

import com.sprint.configuration.ProjectConfiguration;
import com.sprint.model.Comment;
import com.sprint.services.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var comment = new Comment();
        comment.setAuthor("Atharva");
        comment.setText("This is spring");

        var commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);
    }
}