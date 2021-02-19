package com.example.lib.Extend;

public class ExtendTest {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.func1();
    }
}

 class Parent {
    void func2() {
        System.out.println("parent print");
    }

    void func1() {
        func2();
    }
}

class Child extends Parent {
    void func1(int i) {
        System.out.println("child print");
    }
    void func2() {
        System.out.println("child print 2");
    }
}
