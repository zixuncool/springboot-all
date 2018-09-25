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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName : com.rumo.serialize.SerializeTest
 * @Description: todo
 * @Author:mofeng
 * @Date 2018/7/29 0:07
 * @Version 1.0
 */
public class SerializeTest {


    public static void serialize(Object object,String outFile){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFile));
            //往磁盘中写入当前内存中对象的状态
            outputStream.writeObject(object);
            outputStream.flush();
            outputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static  Object deserialize(String outFile){
        try {
            ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream(outFile));
            //往磁盘中写入当前内存中对象的状态
            Object object = inputStream.readObject();
            inputStream.close();
            return  object;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){

        Student student = new Student(1,"mofeng",32,"长沙");
        String filename ="student.out";
        serialize(student,filename);

        Student student1 = (Student) deserialize(filename);
        System.out.println( student1.getId());
        System.out.println( student1.getName());
        System.out.println( student1.getAge());
        System.out.println( student1.getAddress());
        System.out.println( student1 == student);

        /**=====================================*/

        Person person = new Person(1,"mofeng");
        String filename2 ="student.out";
        serialize(person,filename);

        Person person1 = (Person) deserialize(filename2);
        System.out.println( person1.getId());
        System.out.println( person1.getName());
        System.out.println( person == person1);


        //应用类型，值类型
        //Student student3 = new Student();
        //Student student4 =student3;//浅克隆
        System.out.println( "======================================");
        Memeber memeber = Memeber.getIntsance();
        memeber.setId(1);
        memeber.setName("keke");
        String filename4 = "member.out";
        serialize(memeber,filename4);

        Memeber memeber2 = (Memeber)deserialize(filename4);
        System.out.println( memeber == memeber2);
    }

}
