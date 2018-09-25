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
public class Player extends  Thread {

    private static int count = 1;
    private final int id = count ++;
    private static CountDownLatch countDownLatch = new CountDownLatch(3);

    public void run(){
        System.out.println("玩家【"+id+"】进场了...");
        countDownLatch.countDown();//线程挂起
    }

    public static void main(String[] args){
        try {
            new Player().start();
            new Player().start();
            new Player().start();
            countDownLatch.await();//阻塞主线程
            System.out.println("玩家已经到齐，准备开始发牌....");
        }catch (Exception ex){

        }


    }


}
