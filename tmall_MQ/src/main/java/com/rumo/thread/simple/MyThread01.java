package com.rumo.thread.simple;

public class MyThread01 extends Thread {


    private int count = 5;

    //synchronized加锁
    public  void run(){
        count--;
        System.out.println(this.currentThread().getName()+"==>count="+count);
    }

    public static void main(String[] args){

        /**
         *
         * 线程安全的概念：当多个线程访问某一个类对象或者方法的时候，这个类始终都能表现出正确的行为，
         * 那么这个类（对象和方法）就是线程安装的
         * synchronized：可以在任意对象及方法上加锁，而加锁的这段代码成为互斥区或者临界区。
         *
         *
         * 分析：当线程访问MyThread的run方法时。以排队的方式进行处理，（z这里排队的意思是按照cpu执行的先后顺序）.
         * 一个线程要执行synchronized修饰方法的代码：
         * 1：尝试获得锁
         * 2：如果拿到锁，执行synchronized代码内容，如果没有拿到锁，这个线程就会不断的去尝试获得这把锁，知道拿到为止。
         * 而且多个线程同时去竞争这把锁，也就所谓的锁竞争问题。
         */
        MyThread01 thread = new MyThread01();
        Thread t1 = new Thread(thread,"t1");
        Thread t2 = new Thread(thread,"t2");
        Thread t3 = new Thread(thread,"t3");
        Thread t4 = new Thread(thread,"t4");
        Thread t5 = new Thread(thread,"t5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }


}
