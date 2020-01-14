package com.bdp.project.area.service.impl;

import com.bdp.project.area.dao.AreaDao;
import com.bdp.project.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = {"area"})
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    @Override
    @Cacheable(key = "targetClass + methodName +#parentCode")
    public List<Map<String, Object>> children(String parentCode) throws Exception {
        return  areaDao.children(parentCode);
    }
    // @Cacheable(value = "emp",key = "#p0.id")
    // @Cacheable(key = "targetClass + methodName +#parentCode")
   // @CachePut(value = "emp", key = "targetClass + #p0")
    // @CacheEvict(value="emp",key="#id")
    // @CacheEvict(value="accountCache",allEntries=true)
    // @CacheEvict(value="accountCache",beforeInvocation=true)

  /*
      @Caching(cacheable = {
            @Cacheable(value = "emp",key = "#p0"),
            },
            put = {
                    @CachePut(value = "emp",key = "#p0"),
            },evict = {
            @CacheEvict(value = "emp",key = "#p0"),
            })
   */
}
