package com.rumo.thread.simple;


//同步和异步的概念是：当多线程执行的时候吗，异步的方法并不需要竞争锁，会同时执行，如果都被synchronized的方法执行的时候，就会占用锁。
public class MyObject03 {

    public synchronized  void test1(){
        try {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(4000);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public synchronized void test2(){
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args){

        final MyObject03 m = new MyObject03();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.test1();
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m.test2();
            }
        },"t2");

        t1.start();
        t2.start();

    }

}
