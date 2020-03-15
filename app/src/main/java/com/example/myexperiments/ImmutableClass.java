package com.example.myexperiments;

//1 it should be final class
public class ImmutableClass {
    //2.All field must be final
    private final int a = 20;
    private final int b = 30;
    private final int c;

    //5. parameterised
    public ImmutableClass(int c) {
        this.c = c;
    }

    //3. No setter must be provided


    //4. Only getter are available
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public static void main() {
        final ImmutableClass immutableClass = new ImmutableClass(4000);
        System.out.println("a : " + immutableClass.a + " b: " + immutableClass.b + " c : " + immutableClass.c);
    }
}
