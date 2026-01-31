package com.sprint;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main{
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        //create instance to add to context
        Parrot x = new Parrot();
        x.setName("Kiki");

        //define supplier to return this instance
        Supplier<Parrot> parrotSupplier = ()->x;

        //call registerbean to add instance to context
        context.registerBean("parrot1", Parrot.class, parrotSupplier);

        Parrot p = context.getBean(Parrot.class);
        System.out.println(p.getName());

    }
}