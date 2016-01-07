package com.andy.study.base.cache.interfaces;
import redis.clients.jedis.ShardedJedis;
//这个接口是操作sharedJedis
public interface IRedisDataSource {
    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}