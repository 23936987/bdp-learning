package com.bdp.service;

import com.bdp.entity.User;

public interface J2cacheService {


    public String addCache(String key,String value);

    public String queryCache(String type);

    public String getKey(String key);

    public String deleteKey(String key);

    String object_set();

    User object_get(String id);
}
