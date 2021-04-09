package test;

import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: leetcode
 * @description:
 * @author: Micah
 * @create: 2021-03-26 22:01
 **/
public class Test {
    public static final String a = "a";

    private static Lock lock = new ReentrantLock();

    static {
        System.out.println("B");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                lock.lock();
                Thread.sleep(1000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        },"thread-0").start();

        Thread.sleep(2000);
        new Thread(() -> {
            try {
                lock.lock();
            }  finally {
                lock.unlock();
            }
        },"thread-1").start();


        /*Thread.sleep(5000);
        new Thread(() -> {
            try {
                lock.lock();
            }  finally {
                lock.unlock();
            }
        },"thread-3").start();*/
    }
}
