package com.bdp.project.area.service.impl;

import com.bdp.project.area.dao.AreaDao;
import com.bdp.project.area.dto.AreaDTO;
import com.bdp.project.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@CacheConfig(cacheNames = {"area"})
public class AreaServiceImpl implements AreaService {


    @Autowired
    private AreaDao areaDao;

    @Override
    @Cacheable(key = "'children' + #parentCode")
    public List<Map<String, Object>> children(String parentCode) throws Exception {
        return  areaDao.children(parentCode);
    }

    @Override
    @Cacheable(key = "#areaCode")
    public Map<String,Object> queryByAreaCode(String areaCode) throws Exception {
        return  areaDao.queryByAreaCode(areaCode);
    }

    @Caching(
            evict = {
                    @CacheEvict(allEntries=true)
            }
    )
    @Override
    public Map<String, Object> update(AreaDTO areaDTO, String areaCode) throws Exception {
        Map<String, Object> result = new HashMap<>();
        result.put("areaCode",areaCode);
        result.put("areaName",areaDTO.getAreaName());
        areaDao.update(areaDTO,areaCode);
        return result;
    }

    @Override
    public AreaDTO queryDtoByAreaCode(String areaCode) throws Exception {

        Map<String,Object> item = queryByAreaCode(areaCode);
        AreaDTO areaDTO = new AreaDTO();
        areaDTO.setAreaCode(String.valueOf(item.get("areaCode")));
        areaDTO.setAreaName(String.valueOf(item.get("areaName")));
        return areaDTO;
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
