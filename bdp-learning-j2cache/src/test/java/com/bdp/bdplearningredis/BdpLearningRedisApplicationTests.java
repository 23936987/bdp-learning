package com.bdp.bdplearningredis;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.J2Cache;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest
class BdpLearningRedisApplicationTests {

    @Test
    void contextLoads() {
        CacheChannel cache = J2Cache.getChannel();

        //缓存操作

        cache.set("default", "1", "Hello J2Cache");
        System.out.println(cache.get("default", "1"));


        cache.set("default", "2", "Hello J2Cache");
        System.out.println(cache.get("default", "2"));

        //cache.evict("default", "1");
        //System.out.println(cache.get("default", "1"));

        cache.close();
    }


}
