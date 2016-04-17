package com.drozda.learning;

/**
 * Created by GFH on 17.04.2016.
 */
public class Citizen {
    private final int age;
    private final String name;

    public Citizen(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
