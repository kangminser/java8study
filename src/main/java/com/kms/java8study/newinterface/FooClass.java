package com.kms.java8study.newinterface;

public class FooClass implements Foo {

    private String name;

    public FooClass(String name) {
        this.name = name;
    }

    @Override
    public void printFoo() {

    }

    @Override
    public String getName() {
        return name;
    }
}
