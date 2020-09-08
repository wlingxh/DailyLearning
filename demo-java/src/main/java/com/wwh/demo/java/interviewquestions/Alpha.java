package com.wwh.demo.java.interviewquestions;

public class Alpha {
    public void foo() {
        System.out.print("Afoo ");
    }

    public static void main(String[] args) {
        int a=5;
        int b=++a;
        int c = a + (++b);
        System.out.println(c);
        //

    }
}

class Beta extends Alpha {
    public void foo() {
        System.out.print("Bfoo");
    }

    public static void main(String[] args) {
        Alpha a = new Beta();
        Beta b = (Beta) a;
        a.foo();
        b.foo();
    }
}
