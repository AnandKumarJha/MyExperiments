package com.example.myexperiments;

public class ImmutableChildClass extends ImmutableClass {
    ImmutableChildClass(int c) {
        super(c);
    }

    public static void main(String[] args) {
        //In one way I am able to change the value of c from child class that's why the Base class is made final to make it immutable
        ImmutableChildClass immutableChildClass = new ImmutableChildClass(4);
        System.out.println("A: " + immutableChildClass.getA() + " B:" + immutableChildClass.getB() + " C: " + immutableChildClass.getC());
    }
}
