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
 * @ClassName : com.rumo.thread.simple.ObjectLock05
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/23 13:54
 * @Version 1.0
 */
public class ModifyLock07 {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public  synchronized  void modifyAttribute(String name,Integer age){
        try {
            System.out.println("当前线程："+Thread.currentThread().getName()+"  开始");
            this.setName(name);
            this.setAge(age);
            System.out.println("当前线程："+Thread.currentThread()+"当前线程修改以后的内容是：name = "+name+"，age = "+age);
            Thread.sleep(1000);
            System.out.println("当前线程："+ Thread.currentThread().getName()+" 结束");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    public static void main(String[] args){
        final ModifyLock07 lock05 = new ModifyLock07();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock05.modifyAttribute("mofeng",32);
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lock05.modifyAttribute("mofeng123",23);
            }
        },"t2");
        t2.start();



    }
}
