//package com.rumo.thread.lock;
////                            _ooOoo_
////                           o8888888o
////                           88" . "88
////                           (| -_- |)
////                            O\ = /O
////                        ____/`---'\____
////                      .   ' \\| |// `.
////                       / \\||| : |||// \
////                     / _||||| -:- |||||- \
////                       | | \\\ - /// | |
////                     | \_| ''\---/'' | |
////                      \ .-\__ `-` ___/-. /
////                   ___`. .' /--.--\ `. . __
////                ."" '< `.___\_<|>_/___.' >'"".
////               | | : `- \`.;`\ _ /`;.`/ - ` : | |
////                 \ \ `-. \_ __\ /__ _/ .-` / /
////         ======`-.____`-.___\_____/___.-`____.-'======
////                            `=---='
////
////         .............................................
////                  佛祖镇楼                  BUG辟易
////          佛曰:
////                  写字楼里写字间，写字间里程序员；
////                  程序人员写程序，又拿程序换酒钱。
////                  酒醒只在网上坐，酒醉还来网下眠；
////                  酒醉酒醒日复日，网上网下年复年。
////                  但愿老死电脑间，不愿鞠躬老板前；
////                  奔驰宝马贵者趣，公交自行程序员。
////                  别人笑我忒疯癫，我笑自己命太贱；
////                  不见满街漂亮妹，哪个归得程序员？
//
//import java.util.concurrent.CountDownLatch;
//
///**
// * @ClassName : com.rumo.thread.lock.OrderTask
// * @Description: todo
// * @Author:mofeng
// * @Date 2018/7/23 19:31
// * @Version 1.0
// */
//public class OrderTask implements  Runnable {
//
//    private CountDownLatch countDownLatch = null;
//    private OrderService orderService = null;
//
//    public OrderTask(CountDownLatch countDownLatch,OrderService orderServer){
//        this.countDownLatch = countDownLatch;
//        this.orderService = orderServer;
//    }
//    public void run(){
//        try {
//            countDownLatch.await();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        System.out.println(Thread.currentThread().getName()+"订单号是："+orderService.getOrder());
//    }
//}
