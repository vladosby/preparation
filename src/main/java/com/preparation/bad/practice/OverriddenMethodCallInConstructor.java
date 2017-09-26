package com.preparation.bad.practice;

/**
 * Description of class OverriddenMethodCallInConstructor
 *
 * @created: 9/26/2017
 */
public class OverriddenMethodCallInConstructor {
    public static void main(String[] args) {
        Parent p = new Child();
    }
}

class Parent {
    public Parent() {
        printMessage();
    }

    public void printMessage() {
        System.out.println("Hello World");
    }
}

class Child extends Parent {
    private String message = "Hi All!";

    @Override
    public void printMessage() {
        System.out.println(message);
    }
}
