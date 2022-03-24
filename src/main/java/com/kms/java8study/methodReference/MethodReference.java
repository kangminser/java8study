package com.kms.java8study.methodReference;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {

    public static void main(String[] args) {

        UnaryOperator<String> hi = (s) -> "hi";

        // 스테틱 메소트 레퍼런스
        UnaryOperator<String> staticMethodReferce = Greeting::hi;

        Greeting greeting = new Greeting();

        // 인스턴스 메소드 레퍼런스
        UnaryOperator<String> stringUnaryOperator = greeting::hello;

        // 생성자 메소트 레퍼런스
        Supplier<Greeting> supplier = Greeting::new;

        // 생성자 메소트 레퍼런스
        Function<String, Greeting> stringGreetingFunction = Greeting::new;
        Greeting minseo = stringGreetingFunction.apply("minseo");

        //불특정 다수 메소드 레퍼런스
        String[] names = {"a", "b", "c"};
        Arrays.sort(names, String::compareToIgnoreCase);


    }
}
