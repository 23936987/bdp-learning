package com.bdp.project.area.service;

import com.bdp.project.area.dto.AreaDTO;

import java.util.List;
import java.util.Map;

public interface AreaService {
    List<Map<String, Object>> children(String parentCode) throws Exception;

    Map<String,Object> queryByAreaCode(String areaCode) throws Exception;

    AreaDTO queryDtoByAreaCode(String areaCode)  throws Exception;

    Map<String,Object> update(AreaDTO areaDTO, String areaCode) throws Exception;
}
