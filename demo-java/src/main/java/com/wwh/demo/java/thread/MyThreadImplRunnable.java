package com.wwh.demo.java.thread;

/**
 * 实现Runnable创建线程
 */
public class MyThreadImplRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("myThreadImplRunnable ...");
    }

    public static void main(String[] args) {
        MyThreadImplRunnable myThreadImplRunnable = new MyThreadImplRunnable();
        Thread thread = new Thread(myThreadImplRunnable);
        thread.start();
    }
}
