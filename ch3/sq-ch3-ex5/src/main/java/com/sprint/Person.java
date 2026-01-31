package com.sprint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
    private String name = "Atharva";

    private final Parrot parrot;

    @Autowired
    public Person(Parrot parrot){
        this.parrot = parrot;
    }

    public String getName() {
        return name;
    }

    public Parrot getParrot() {
        return parrot;


    }
}
