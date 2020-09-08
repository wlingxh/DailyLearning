package com.wwh.demo.java.thread;

import java.util.concurrent.Callable;

/**
 * 实现Callable创建线程，有返回值，
 */
public class MyThreadImplCallable implements Callable<String> {
    private String threadName;

    public MyThreadImplCallable(String name) {
        threadName = String.format("Thread---%s", name);
    }

    @Override
    public String call() throws Exception {
        return threadName;
    }
}
