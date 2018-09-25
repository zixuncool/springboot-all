package com.rumo.thread.simple;

/**
 * 多个线程多个锁
 * 多个线程，每个线程都可以拿到制定的锁，分别获得锁之后，执行synchronized方法体的enrich。
 * 总结：
 * 关键字synchronized取得锁都是对象锁，而不是把一段代码当做锁，那个线程先执行synchronized关键字的方法
 * ，那个线程就持有方法所属对象的锁，两个对象，线程获取的就是两个不同的锁，他们互不影响，
 * 有一种情况则是相同的锁，就在静态方法上加synchronized关键字，表是类锁，
 *
 *
 * 同步和异步的概念：
 * 同步的概念就是共享，我们要牢牢记住共享这个词，如果不是共享的资源，就没必要进行同步。
 * 异步的概念就是独立，相互之间不受到任何制约，就好像我们学习http的时候，在页面发起ajax请求，我们还可以继续浏览或者操作页面的内容。二者之间没有任何联系。
 * 所谓异步和同步的概念就是指在多线程环境下执行一个类的方法的行为，如果加了synchronized的方法就是同步方法，如果没有加那么多线程执行类中的方法的时候都是并发执行。
 *
 * 同步的目的是为了线程安全，其实对于线程安全来说没需要满足两个特性：
 * 1：原子性
 * 2：可见性
 */
public class MutilThread02 {

    //static
    private int num = 0;

    //static的类锁,加了static以后都成为了类锁，就是代表一个对象引用，下面执行的结果就按照顺序完成
    public synchronized  void print(String msg){
        try {
            if(msg.equals("a")){
                num = 100;
                System.out.println("msg a ,set num success");
                Thread.sleep(1000);
            }else{
                num = 200;
                System.out.println("msg b set num success");
            }

            System.out.println("msg="+msg+",num="+num);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //注意观察run方法输入顺序
    public static void main(String[] args) {

        //两个不同的对象
        final  MutilThread02 m1 = new MutilThread02();
        final  MutilThread02 m2 = new MutilThread02();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                m1.print("a");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                m2.print("b");
            }
        });

        t1.start();
        t2.start();
    }
}
