package com.wwh.demo.java.thread;

public class MyThreadTestInterrupt extends Thread {

    public void run() {
        while (!Thread.interrupted()) {
            try {
                System.out.println("-----------------------------------");
                Thread.sleep(2000);
                System.out.println("休眠2后以后：" + Thread.interrupted());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("异常时：线程的中断标志是：-------" + Thread.interrupted());
                break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThreadTestInterrupt thread = new MyThreadTestInterrupt();
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("主方法休眠5s后中断，此时中断标志为：-----------" + thread.isInterrupted());
    }
}
