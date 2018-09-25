package com.rumo.zookeeper;
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


import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName : com.rumo.zookeeper.Test
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/23 15:53
 * @Version 1.0
 */
public class Test implements Watcher {


    private static CountDownLatch countDownLatch = new CountDownLatch(1);
    private static ZooKeeper zk = null;
    private static Stat stat = new Stat();
    public static void main(String[] args){

       try {
           //zookeeper配置数据存放路径
           String path = "/username";
           //链接zookeeper
           zk = new ZooKeeper("ip:port",5000,new Test());
           //等待zk链接成功通知
           countDownLatch.await();
           //打印数据
           System.out.println(new String(zk.getData(path,true,stat)));

           //永远等待
           System.in.read();

       }catch (Exception ex){
           ex.printStackTrace();
       }
    }

    public void process(WatchedEvent event){
        if(Event.KeeperState.SyncConnected == event.getState()){//zk链接成功通知
            if(Event.EventType.None == event.getType() && null == event.getPath()){
                countDownLatch.countDown();
            }else if(event.getType()==Event.EventType.NodeDataChanged){
                try {
                    //zookeeper配置数据存放路径
                    String path = "/username";
                    System.out.println(new String(zk.getData(path,true,stat)));
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
    }
}
