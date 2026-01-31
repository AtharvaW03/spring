package com.sprint;

import org.springframework.stereotype.Component;

@Component
public class Parrot {

//    public Parrot(){
//        System.out.println("Parrot created");
//    }

    private String name = "Koko";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "Parrot: " + name;
    }
}
