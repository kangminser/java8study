package com.kms.java8study.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OnlineClassMain {

    public static void main(String[] args) {
        List<OnlineClass> onlineClassList = new ArrayList<>();

        onlineClassList.add(new OnlineClass(1, "Spring111", true));
        onlineClassList.add(new OnlineClass(2, "22", true));
        onlineClassList.add(new OnlineClass(3, "Spring33", true));
        onlineClassList.add(new OnlineClass(4, "44", true));
        onlineClassList.add(new OnlineClass(5, "Spring55", false));
        onlineClassList.add(new OnlineClass(6, "66", true));
        onlineClassList.add(new OnlineClass(7, "77", false));
        onlineClassList.add(new OnlineClass(8, "88", true));

        List<List<OnlineClass>> onlineClassList2 = new ArrayList<>();
        onlineClassList2.add(onlineClassList);

        System.out.println("Spring으로 시작하는 수업");

        List<OnlineClass> springClassList = onlineClassList.stream()
                .filter(onlieClass -> onlieClass.getClassName().startsWith("Spring"))
                .collect(Collectors.toList());

        springClassList.forEach(System.out::println);

        System.out.println("close 되지 않은 수업");

        List<OnlineClass> openClass = onlineClassList.stream()
                .filter(Predicate.not(OnlineClass::isOpen))
                .collect(Collectors.toList());

        openClass.forEach(isOpenedClass -> System.out.println(isOpenedClass.getClassName()));

        System.out.println("수업 이름만 모아서 스트림 만들기");

        onlineClassList.stream()
                .map(OnlineClass::getClassName)
                .forEach(System.out::println);

        System.out.println("두 수업 목록이 들어있는 모든 수업 아이디 출력");

        onlineClassList2.stream()
                .flatMap(list -> list.stream())
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");

        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("수업 중에 Spring이 들어있는지");

        boolean spring = onlineClassList.stream().anyMatch(oc -> oc.getClassName().contains("Spring"));
        System.out.println(spring);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 리스트로 만들기");

        List<String> spring1 = onlineClassList.stream()
                .filter(oc -> oc.getClassName().contains("Spring"))
                .map(OnlineClass::getClassName)
                .collect(Collectors.toList());

        spring1.stream().forEach(System.out::println);

    }
}
