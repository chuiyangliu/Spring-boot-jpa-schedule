package com.zict.fourthde.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class JedisAdapter implements InitializingBean {

    private JedisPool pool=null;

    private static final Logger logger= LoggerFactory.getLogger(JedisAdapter.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        pool =new JedisPool("localhost",6379);
    }


    public boolean sismember(String key,String val){
        Jedis jedis=null;
        try{
            jedis=pool.getResource();
            return jedis.sismember(key,val);
        }catch (Exception e){
            logger.error("发生异常"+e.getMessage());
            return false;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long sadd(String key,String val){
        Jedis jedis=null;
        try{
            jedis=pool.getResource();
            return jedis.sadd(key,val);
        }catch (Exception e){
            logger.error("发生异常"+e.getMessage());
            return 0;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }

    public long scard(String key){
        Jedis jedis=null;
        try{
            jedis=pool.getResource();
            return jedis.scard(key);
        }catch (Exception e){
            logger.error("发生异常"+e.getMessage());
            return 0;
        }finally {
            if(jedis!=null){
                jedis.close();
            }
        }
    }


}
