package com.sprint;

import com.sprint.services.CommentService;
import com.sprint.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfiguration.class);

        var s1 = context.getBean(CommentService.class);
        var s2 = context.getBean(UserService.class);

        boolean b = s1.getCommentRepository()==s2.getCommentRepository();

        System.out.println(s1.getCommentRepository());
        System.out.println(s2.getCommentRepository());
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(b);

    }
}