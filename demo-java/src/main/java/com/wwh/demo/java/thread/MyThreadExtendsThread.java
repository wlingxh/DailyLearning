package com.wwh.demo.java.thread;

import java.io.File;

/**
 * 继承thread创建线程
 */
public class MyThreadExtendsThread extends Thread {
    volatile boolean stop = false;

    public void run() {
        while (!isInterrupted()) {
            System.out.println("----------------------------: " + isInterrupted());
            System.out.println("myThreadExtendsThread runing ...");
            try {
                System.out.println("myThreadExtendsThread start sleep");
                Thread.sleep(1000);
                System.out.println("myThreadExtendsThread end sleep");
            } catch (Exception e) {
                System.out.println("myThreadExtendsThread week up from block");
//                stop = true;
            }
        }
    }

    /**
     * 如何停止一个正在运行的线程
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        MyThreadExtendsThread myThreadExtendsThread = new MyThreadExtendsThread();
        myThreadExtendsThread.start();
        Thread.sleep(3000);
        //第一种：设置推出标准
//        myThreadExtendsThread.stop = true;
        //第二种：使用interrupt方法中断线程
        myThreadExtendsThread.interrupt();
        System.out.println(myThreadExtendsThread.isInterrupted());
        Thread.sleep(3000);

    }
}
