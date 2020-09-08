package com.wwh.demo.java.interviewquestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringQuestion {

    public static void main(String[] args) {
        String str1 = "banalan";
        String str2 = "bana" + new String("lan");
        String str3 = "banalan";
        String str4 = "bana" + "lan";
        System.err.println(str1 == str2);
        System.err.println(str1 == str3);
        System.err.println(str1 == str4);
//
//        String s =new String ("xyz");
        //文字替换（全部）
        Pattern pattern = Pattern.compile("正则表达式");
        Matcher matcher = pattern.matcher("正则表达式 Hello World,正则表达式 Hello World");
        //替换第一个符合正则的数据
        System.out.println(matcher.replaceAll("Java"));

    }
}
