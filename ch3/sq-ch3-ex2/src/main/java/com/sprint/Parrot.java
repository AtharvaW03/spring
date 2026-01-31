package com.sprint;

public class Parrot {

    public Parrot(){
        System.out.println("Parrot created");
    }

    private String name;

    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Parrot:  " + name;
    }
}
