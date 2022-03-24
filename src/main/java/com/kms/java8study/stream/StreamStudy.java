package com.kms.java8study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamStudy {

    public static void main(String[] args) {
        stream();
    }

    public static void stream(){
        List<String> names = new ArrayList<>();
        names.add("a");
        names.add("b");

        // 스트림은 데이터를 바꾸지 않는다.
        Stream<String> stringStream = names.stream().map(String::toUpperCase);

        // 중계 오퍼레이션은 근본적으로 lazy하다
        // 중계 오퍼레이션 -> Stream을 리턴한다
        Stream<String> stringStream1 = names.stream().map((s) -> {
            System.out.println("s = " + s); //출력안됨
            return s.toUpperCase();
        });

        System.out.println("===================");
        // 종료 오퍼레이션 -> Stream을 리턴하지 않는다.
        List<String> collect = stringStream1.collect(Collectors.toList());// 종료형 오퍼레이터 실행시 위의 sysout이 찍힘
        names.forEach(System.out::println);

        //stream은 병렬처리가 가능하다
        List<Object> collect1 = names.parallelStream().map((s) -> {
            System.out.println("Thread.currentThread().getName() = " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        collect.forEach(System.out::println);

    }
}
