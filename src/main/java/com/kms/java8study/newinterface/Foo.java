package com.kms.java8study.newinterface;

public interface Foo {

    void printFoo();

    // 기존에 implements 받은 class에 구현할 필요가 없다.

    /**
     * @implSpec 을 사용하여 상세구현 내용에 대하여 적어준다.
     */
    default void printNewFoo() {
        System.out.println(getName());
    }

    String getName();

}
