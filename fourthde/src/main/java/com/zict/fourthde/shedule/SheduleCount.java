package com.zict.fourthde.shedule;



import com.zict.fourthde.utils.JedisAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SheduleCount {

    private String key = "key";

    @Autowired
    JedisAdapter jedisAdapter;

    @Scheduled(cron="*/5 * * * * ?")
    private void process(){
        int count = (int) jedisAdapter.scard(key);
        System.out.println("the counts of user is:  "+count);
    }


}
