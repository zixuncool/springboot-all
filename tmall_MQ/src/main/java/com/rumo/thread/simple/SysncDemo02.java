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
 * @ClassName : com.rumo.thread.simple.SysncDemo01
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/23 13:14
 * @Version 1.0
 */

//synchronized重入的问题
public class SysncDemo02 {

    static class Parent{
        public int i = 10;
        public synchronized  void opParent(){
            try {
                i--;
                System.out.println("Parent Operator i = " + i);
                Thread.sleep(100);
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    static class SubChildren extends  Parent{
        public synchronized  void opSub(){
            try {
                while (i>0){
                    i--;
                    System.out.println("SubChildren Operator i = " + i);
                    Thread.sleep(100);
                    //调用父类的方法
                    this.opParent();
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }


    public static void main(String[] args){


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SubChildren subChildren = new SubChildren();
                subChildren.opSub();
            }
        });
        thread.start();

    }
}
