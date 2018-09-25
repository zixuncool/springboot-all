package com.rumo.serialize;
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

import java.io.*;

/**
 * @ClassName : com.rumo.serialize.Student
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/29 0:06
 * @Version 1.0
 */
public class Memeber implements Serializable {

    transient  private Integer id;
    private String name;

    //深克隆
    public Memeber(){}

    public Memeber(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private static class InnerClass{
        private static final Memeber memeber = new Memeber();
    }

    public static Memeber getIntsance(){
        return InnerClass.memeber;
    }

    //同时满足序列化和单列模式，当jvm从内存中反序列化组装一个对象时候，会自动调用改方法。
    //改方法返回的是指定对象的单列模式对象，这样单列规则得到了保证
    private Object readResolve() throws  ObjectStreamException{
        return InnerClass.memeber;
    }
}






