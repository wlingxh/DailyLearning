package com.wwh.demo.java.executor;

import com.wwh.demo.java.thread.MyThreadImplCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * 线程池
 */
public class MyExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskThread = 5;
        //创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskThread);
        List<Future> list = new ArrayList<>();
        //创建多个返回值的任务
        for (int i = 0; i < taskThread; i++) {
            Callable callable = new MyThreadImplCallable(i + "");
            //执行任务并获取Future对象
            Future future = pool.submit(callable);
            list.add(future);
        }
        //关闭线程池
        pool.shutdown();
        for (Future future : list) {
            //从Future对象中获取对象返回值
            System.out.println("res: " + future.get().toString());
        }
    }
}
