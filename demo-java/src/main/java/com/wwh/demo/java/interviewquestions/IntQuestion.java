package com.wwh.demo.java.interviewquestions;

import java.util.Map;

public class IntQuestion {

    public static void main(String[] args) {
        Double i = 10.0;
        int j = 1;
        System.out.println(i + j);
        float f = 1.0f;
        double d = 1.0;

        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println(a+1);

        Integer c=1;
        System.out.println(c==1?"等于":"不等于");
        Boolean bool=false;
        System.out.println(bool?"真":"假");
    }

}

class test1{
    Integer i;
    int x;

    public test1(int y) {
        x = i + y;
        System.out.println(x);
    }
}
