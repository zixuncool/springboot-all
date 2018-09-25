package com.rumo.rabbitmq.spring2;

//
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
//  


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by jackiechan on 2018/4/5/下午5:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext2.xml"})
public class TestMain {
    @Autowired
    private PublishUtil publishUtil;

    private static String exChange = "DIRECT_EX";//交换机
    private static String queue = "CONFIRM_TEST";

    /**
     * EXCHANGE QUEUE都对, confirm 会执行, ack=true
     * @throws Exception
     */
    @Test
    public void test1()  throws Exception{
        String message = "当前时间是:" + System.currentTimeMillis();
        publishUtil.send(exChange, queue, message);
        Thread.sleep(2000);
    }
    /**
     * EXCHANGE错误 QUEUE对, confirm 会执行, ack=false
     * @throws Exception
     */
    @Test
    public void test2()  throws Exception{
        String message = "当前时间是:" + System.currentTimeMillis();
        publishUtil.send(exChange+"!", queue, message);
        Thread.sleep(2000);
    }

    /**
     * EXCHANGE对的 QUEUE错的,confirm 会执行 act=true, 失败会执行
     * @throws Exception
     */
    @Test
    public void test3()  throws Exception{
        String message = "当前时间是:" + System.currentTimeMillis();
        publishUtil.send(exChange, queue+"1", message);
        Thread.sleep(2000);
    }


    /**
     * EXCHANGE QUEUE都是错的 confirm 会执行,但是ack=false
     * @throws Exception
     */
    @Test
    public void test4()  throws Exception{
        String message = "当前时间是:" + System.currentTimeMillis();
        publishUtil.send(exChange+"`", queue+"1", message);
        Thread.sleep(2000);
    }
}
