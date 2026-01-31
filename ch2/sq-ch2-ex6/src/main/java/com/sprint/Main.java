package com.sprint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot p = context.getBean(Parrot.class);

        p.setName("ahhahahha");

        System.out.println(p);
        System.out.println(p.getName());
    }
}
