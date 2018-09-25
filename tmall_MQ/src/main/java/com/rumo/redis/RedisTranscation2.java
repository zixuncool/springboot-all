package com.rumo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * Created by mofeng
 */
public class RedisTranscation2 {


    public boolean transBanlance() throws  Exception{
        Jedis jedis = RedisPool.getJedis();
        int balance; //可用余额
        int debt;//欠额
        int amtosubtract = 10;//实刷额度
        //加个watch监控
        jedis.watch("balance");
        //jedis.set("balance","5");//这里会放弃后面的事务.
        //Thread.sleep(7000);
        //监视一个或者多个key,如果在事务执行之前这个key被执行之前所改动，那么事务将会被打断，其实也就是锁的概念
        balance = Integer.parseInt(jedis.get("balance"));
        if(balance < amtosubtract){//余额小于实刷金额
            jedis.unwatch();//放弃修改
            System.out.println("modify ");
            return false;
        }else{
            System.out.println("*************open transcation...");
            Transaction tx = jedis.multi();
            tx.decrBy("balance",amtosubtract);
            tx.incrBy("debt",amtosubtract);
            //提交事务
            tx.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println("余额是："+balance);
            System.out.println("欠额额是："+debt);
            return true;
        }
    };

    public static void main(String[] args) throws  Exception{
        RedisTranscation2 transcation2 = new RedisTranscation2();
        boolean flag =  transcation2.transBanlance();
        System.out.println(flag?"消费成功":"余额不足");
    }


}