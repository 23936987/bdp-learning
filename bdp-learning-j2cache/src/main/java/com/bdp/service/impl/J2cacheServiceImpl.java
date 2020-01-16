package com.bdp.service.impl;

import com.alibaba.fastjson.JSON;
import com.bdp.entity.User;
import com.bdp.service.J2cacheService;
import net.oschina.j2cache.CacheChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class J2cacheServiceImpl implements J2cacheService {

    @Autowired
    CacheChannel cacheChannel;

    @Override
    public String addCache(String key, String value) {
        cacheChannel.set("Euser", key, value);
        return "region:Euser,key:" + key + ",value:" + value;
    }

    @Override
    public String queryCache(String type) {

        StringBuilder sb = new StringBuilder();
        if ("1".equals(type)) {
            System.out.println("ehcache缓存==================");
            //CacheProvider l1 = cacheChannel.getL1Provider();
            Collection<String> keys = cacheChannel.keys("Euser");
            for (String key : keys) {
                sb.append("key:" + key + ",value:" + cacheChannel.get("Euser", key));
            }
        } else if ("2".equals(type)) {
            System.out.println("redis二级缓存================");
            //CacheProvider l2 = cacheChannel.getL2Provider();
            Collection<String> keys = cacheChannel.keys("Euser");
            for (String key : keys) {
                sb.append("key:" + key + ",value:" + cacheChannel.get("Euser", key));
            }
        }
        return sb.toString();
    }

    @Override
    public String getKey(String key) {
        Object v = cacheChannel.get("Euser", key);
        if (v != null) {
            return v.toString();
        }
        return "null";
    }

    @Override
    public String deleteKey(String key) {
        cacheChannel.evict("Euser", key);
        return "success";
    }

    @Override
    public String object_set() {
        User user =  new User();
        user.setId("1");
        user.setName("zhangsan");

        cacheChannel.set("Euser", "user1", JSON.toJSONString(user));

        return "1";
    }

    @Cacheable(value = "xxxx",key = "#p0")
    public User object_get(String  id) {

        String str = (String) cacheChannel.get("Euser", "user"+id).getValue();

       return JSON.parseObject(str,User.class);

    }



}