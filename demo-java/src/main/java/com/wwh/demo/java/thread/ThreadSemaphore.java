package com.wwh.demo.java.thread;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Semaphore:信号量，
 */
public class ThreadSemaphore {

    public static void main(String[] args) {
        Semaphore semp = new Semaphore(5);
        try {
            semp.acquire();
            try {

                System.out.println(new Random(144).nextInt());
            } catch (Exception e) {
                e.printStackTrace();

            }

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            semp.release();
        }
    }
}
