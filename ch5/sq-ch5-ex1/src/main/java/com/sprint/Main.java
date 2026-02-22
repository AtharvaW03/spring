package com.sprint;

import com.sprint.projectconfig.ProjectConfiguration;
import com.sprint.service.CommentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

class Main{
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);


        var cs1 = context.getBean("commentService", CommentService.class);
        var cs2 = context.getBean("commentService", CommentService.class);

        boolean b1 = cs1==cs2;

        System.out.println(b1);
    }
}