package org.example;

public class Test {
    private int age;
    @MaxValue(6)
    private String name;

    public Test(String name, int age) {
        this.name = name;
        this.age = age;
    }
}