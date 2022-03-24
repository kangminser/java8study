package com.kms.java8study.optional;

import com.kms.java8study.stream.OnlineClass;
import com.kms.java8study.stream.Progress;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {

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

        // 기존 코드
        OnlineClass onlineClass = new OnlineClass(8, "88", true);
        Progress process = onlineClass.getProcess();    //null point exception 발생
        if (process != null) {
            System.out.println(process.getStudyDuration());
        }

        //바뀐 코드
        // Optional은 문법적 제한은 없지만 return type으로 쓰는게 권장사항이다.
        // 매개변수로 쓰지 않는 이유는 매개변수의 Optional 자체가 null 일 수 도 있다.
        // Map에 키타입을 Optional로 쓰지 말아라.
        onlineClass.getOptionalProgress();

        //findFirst 는 Optional 리턴
        Optional<OnlineClass> spring = onlineClassList.stream()
                .filter(oc -> oc.getClassName().startsWith("Spring"))
                .findFirst();

        System.out.println(spring.isPresent());

        OnlineClass onlineClass1 = spring.get();   //되도록 사용하지 말자

        spring.ifPresent(oc -> System.out.println(oc.getClassName()));  // 있으면 호출

        // 있으면 있는 값 반환 , 없으면 세팅해준 값 반환
        // 없어도 createONlineClass() 를 실행한다.
        OnlineClass onlineClass2 = spring.orElse(createONlineClass());
        System.out.println("onlineClass2.getClassName() = " + onlineClass2.getClassName());

        // 있으면 있는 값 반환 , 없으면 세팅해준 값 반환
        // Supplier 라서 없으면 호출하지 않는다.
        OnlineClass onlineClass3 = spring.orElseGet(App::createONlineClass);
        System.out.println("onlineClass3 = " + onlineClass3);

        // 있으면 있는 값 반환 , 없으면 throw
        OnlineClass onlineClass4 = spring.orElseThrow(IllegalStateException::new);

    }

    public static OnlineClass createONlineClass(){
        System.out.println("createONlineClass()");
        return new OnlineClass(8, "88", true);
    }
}
