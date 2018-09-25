package com.rumo.rabbitmq.spring.topic;

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


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mofeng on 2018/4/5/下午5:18
 */
public class SpringTest {
    public static void main(String[] args) throws Exception{
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-topic.xml");
        RabbitTemplate template = context.getBean(RabbitTemplate.class);
         //指定发送到的队列名和消息体
        //template.convertAndSend("topicExchange","abc.123","2222222222222hello word===>");
        template.convertAndSend("leo.pay.topic.exchange","test.hello.test123","3333333333hello word===>");
        //template.convertAndSend("leo.pay.topic.exchange","test321.hello.test123","3333333333hello word===>");
        Thread.sleep(2000);//休眠2秒后，关闭spring容器
        context.close();

    }
}
