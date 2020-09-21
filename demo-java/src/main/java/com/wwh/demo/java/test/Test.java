package com.wwh.demo.java.test;

public class Test {
    public static void main(String[] args) {
        byte[] bytes = {6, 4, 18, 0, 0, 0, -128, 63, -58, 0, 104, 95, 19, 0, 25, 4, -106, 62, -58, 0, 104, 95, 26, 0, -51, -52, 52, 65, -58, 0, 104, 95, 32, 0, 0, 0, 0, 0, -58, 0, 104, 95};
        String res = "{\"dqf\":1,\"sn\":18,\"t\":1600651462000,\"v\":1.0},{\"dqf\":1,\"sn\":19,\"t\":1600651462000,\"v\":0.293},{\"dqf\":1,\"sn\":26,\"t\":1600651462000,\"v\":11.3},{\"dqf\":1,\"sn\":32,\"t\":1600651462000,\"v\":0.0},{\"dqf\":1,\"sn\":32,\"t\":1600651462000,\"v\":0.0},{\"dqf\":1,\"sn\":32,\"t\":1600651462000,\"v\":0.0}";
        System.out.println("bytes size :" + bytes.length + ", 占用空间：" + (16 + bytes.length));
        System.out.println("str length: " + res.length() + ", 占用空间：" + (40 + 2 * res.length()));
    }
}
