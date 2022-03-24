package com.kms.java8study.functionInterface;

public class FunctionInterface {

    public static void main(String[] args) {

        // 기존의 방식
        Runsomthing oldRunSomthing = new Runsomthing() {
            @Override
            public void doit() {
                System.out.println("doit old");
            }
        };

        oldRunSomthing.doit();

        // 람다식 방식
        Runsomthing newRunsomthing = () -> System.out.println("doit new");
        newRunsomthing.doit();
    }
}
