package com.ucarinc.wtf.demo.Concurrence;

import sun.nio.ch.ThreadPool;

import java.util.Hashtable;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ProjectName: shiro-demo
 * @Package: com.ucarinc.wtf.demo.Concurrence
 * @ClassName: Test
 * @Author: tengfei.wu01@ucarinc.com
 * @Description:
 * @Date: 2020/7/17 14:48
 * @Version: 1.0
 */
public class Test {
    public static class ThreadDemo implements Runnable{
        ReentrantLock lock1;
        ReentrantLock lock2;
        ThreadDemo(ReentrantLock lock1, ReentrantLock lock2){
            this.lock1 = lock1;
            this.lock2 = lock2;
        }
        @Override
        public void run() {
            try {
                lock1.lockInterruptibly();
                System.out.println(lock1.getClass().getName()+"加锁成功");
                Thread.sleep(5000);
                lock2.lockInterruptibly();
                System.out.println(lock2.getClass().getName()+"加锁成功");
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock1 = new ReentrantLock(false);
        ReentrantLock lock2 = new ReentrantLock(false);
        Thread thread1 = new Thread(new ThreadDemo(lock1,lock2));
        Thread thread2 = new Thread(new ThreadDemo(lock2,lock1));
        thread1.start();
        thread2.start();
        thread2.interrupt();
        ClassLoader
    }
//    ReentrantLock lock = new ReentrantLock();
//    Condition condition = lock.newCondition();
//    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//    DelayQueue<Delayed> delayQueue = new DelayQueue<Delayed>();
//
//    public Condition getCondition() {
//        return condition;
//    }
//
//    public void test(){
//        lock.lock();
//        try {
//            condition.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }finally {
//            lock.unlock();
//        }
//
//    }
}
