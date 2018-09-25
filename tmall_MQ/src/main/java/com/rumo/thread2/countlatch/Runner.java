package com.rumo.thread2.countlatch;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                            O\ = /O
//                        ____/`---'\____
//                      .   ' \\| |// `.
//                       / \\||| : |||// \
//                     / _||||| -:- |||||- \
//                       | | \\\ - /// | |
//                     | \_| ''\---/'' | |
//                      \ .-\__ `-` ___/-. /
//                   ___`. .' /--.--\ `. . __
//                ."" '< `.___\_<|>_/___.' >'"".
//               | | : `- \`.;`\ _ /`;.`/ - ` : | |
//                 \ \ `-. \_ __\ /__ _/ .-` / /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//
//         .............................................
//                  佛祖镇楼                  BUG辟易
//          佛曰:
//                  写字楼里写字间，写字间里程序员；
//                  程序人员写程序，又拿程序换酒钱。
//                  酒醒只在网上坐，酒醉还来网下眠；
//                  酒醉酒醒日复日，网上网下年复年。
//                  但愿老死电脑间，不愿鞠躬老板前；
//                  奔驰宝马贵者趣，公交自行程序员。
//                  别人笑我忒疯癫，我笑自己命太贱；
//                  不见满街漂亮妹，哪个归得程序员？

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName : com.rumo.thread2.countlatch.Player
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/27 17:05
 * @Version 1.0
 */
public class Runner {

    public static void testCountDownLatch(){

        int threadCount = 10;

        final CountDownLatch latch = new CountDownLatch(threadCount);

        for(int i=0; i< threadCount; i++){

            new Thread(new Runnable() {

                @Override
                public void run() {

                    System.out.println("线程" + Thread.currentThread().getId() + "开始出发");

                    try {
                        Thread.sleep((long)Math.random()*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程" + Thread.currentThread().getId() + "已到达终点");
                    latch.countDown();
                }
            }).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("10个线程已经执行完毕！开始计算排名");
    }

    public static void main(String[] args){
        testCountDownLatch();
    }

    /*
    * 　源码分析：

      　　1、CountDownLatch:A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.

　　　　大致意思：也就是说主线程在等待所有其它的子线程完成后再往下执行

　　　　

　　　　2、构造函数：CountDownLatch(int count)//初始化count数目的同步计数器，只有当同步计数器为0，主线程才会向下执行
　　　　　 主要方法：void await()//当前线程等待计数器为0
      　　　　　　　　 boolean await(long timeout, TimeUnit unit)//与上面的方法不同，它加了一个时间限制。
     　　　　　　　　 void countDown()//计数器减1
      　　　　　　　　long getCount()//获取计数器的值

      　　3.它的内部有一个辅助的内部类：sync.

　　　　   它的实现如下：

    　4.await()方法的实现
      　　sync.acquireSharedInterruptibly(1);
         -->if (tryAcquireShared(arg) < 0)//调用3中的tryAcquireShared()方法
                doAcquireSharedInterruptibly(arg);//加入到等待队列中

    　　5.countDown（）方法的实现
      　　sync.releaseShared(1);
         --> if (tryReleaseShared(arg))//调用3中的tryReleaseShared（）方法
                   doReleaseShared();//解锁
    * */
}
