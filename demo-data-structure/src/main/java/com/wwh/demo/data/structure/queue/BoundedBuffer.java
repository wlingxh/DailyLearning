package com.wwh.demo.data.structure.queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 假设我们有一个界缓冲区，它支持put和take的方法。
 * 如果take尝试对一个空的缓冲器，则该线程将阻塞，直到一个项目变为可用;
 * 如果put试图在一个完整的缓冲区，那么线程将阻塞，直到空间变得可用。
 * 我们愿继续等待put线，并take线程独立的等待集，这样我们就可以使用的只有在当项目或空间的缓冲区变得可用时通知单个线程的优化。
 */
class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length)
                notFull.await();
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)
                notEmpty.await();
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
