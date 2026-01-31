package com.sprint;



public class Parrot {

    public Parrot(){
        System.out.println("Parrot created");
    }

    private String name;

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
