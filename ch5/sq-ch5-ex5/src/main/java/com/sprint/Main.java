package com.sprint;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var c = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var c1=c.getBean(CommentService.class);
        var c2=c.getBean(CommentService.class);

        boolean b1 = c1==c2;
        System.out.println(b1);


    }
}