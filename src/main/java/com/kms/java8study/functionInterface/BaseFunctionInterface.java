package com.kms.java8study.functionInterface;

import java.util.Optional;
import java.util.function.*;

public class BaseFunctionInterface {

    public static void main(String[] args) {

        functionInterce();
        consumerInterface();
        supplierInterface();
        predicateInterface();
    }

    public static void functionInterce() {

        Function<Integer, Integer> plus10 = i -> i + 10;

        System.out.println(plus10.apply(10));   // 20

        Function<Integer, Integer> multiply2 = i -> i * 2;

        // 10*2 + 10
        // 뒤의 multiply2 부터 실행된다.
        // result = 30
        System.out.println(plus10.compose(multiply2).apply(10)); // 고차함수

        // (10+10) * 2
        // compose 와 반대의 개념으로 plus10부터 실행된다.
        // resulr = 40
        System.out.println(plus10.andThen(multiply2).apply(10));
    }

    public static void consumerInterface() {
        // Consumer는 리턴 타입이 없음
        Consumer<Integer> integerConsumer = i -> System.out.println("consumer" + i);

        integerConsumer.accept(10);

        Consumer<Integer> stringConsumer = text -> System.out.println("andthen " + text);

        // integerConsumer.accept 후 stringConsumer 호출
        integerConsumer.andThen(stringConsumer).accept(20);
    }

    public static void supplierInterface() {
        // Supplier 받지 않고 리턴만 있음
        Supplier<String> stringSupplier = () -> "hello";

        System.out.println(stringSupplier.get());
    }

    public static void predicateInterface() {
        // 값을 입력받아 boolean을 리턴

        Predicate<String> stringPredicate = (text) -> "a".equals(text);

        System.out.println(stringPredicate);
    }

    //Fuction이랑 기능은 같지만 타입이 같을 떄 사용
    public static void unaryOperatorInterface(){
        UnaryOperator<Integer> plus10 = i -> i + 10;

        System.out.println(plus10.apply(10));   // 20

        UnaryOperator<Integer> multiply2 = i -> i * 2;

        // 10*2 + 10
        // 뒤의 multiply2 부터 실행된다.
        // result = 30
        System.out.println(plus10.compose(multiply2).apply(10)); // 고차함수

        // (10+10) * 2
        // compose 와 반대의 개념으로 plus10부터 실행된다.
        // resulr = 40
        System.out.println(plus10.andThen(multiply2).apply(10));
    }

}
