package com.rumo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Transaction;

/**
 * Created by mofeng
 */
public class RedisTranscation {

    public static void main(String[] args){
        Jedis jedis = RedisPool.getJedis();
        Transaction tx = jedis.multi();

        tx.set("key1","key44");
        tx.set("key3","key55");

        //提交
        //tx.exec();
        //回滚,放弃
        tx.discard();

    }


}