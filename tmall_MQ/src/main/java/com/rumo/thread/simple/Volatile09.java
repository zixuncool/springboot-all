package com.rumo.thread.simple;
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

/**
 * @ClassName : com.rumo.thread.simple.Volatile09
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/23 14:09
 * @Version 1.0
 */
public class Volatile09 extends  Thread {

    //volatile的概念：主要组作用是使变量在多个线程间可见。
    private volatile boolean isRunning = true;
    private void setRunning(boolean isRunning){
        this.isRunning = isRunning;
    }

    public void run(){
        System.out.println("进入Run方法...");
        while (isRunning == true){

        }
        System.out.println("线程终止");
    }

    public static void main(String[] args) throws InterruptedException {

        Volatile09 volatile09 = new Volatile09();
        volatile09.start();

        Thread.sleep(2000);
        volatile09.setRunning(false);
        System.out.println("is runiing 的值得被设置成了false");
        Thread.sleep(1000);
        System.out.println(volatile09.isRunning);

    }


}
