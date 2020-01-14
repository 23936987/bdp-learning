package com.bdp.project.area.dao;

import com.bdp.project.area.dto.AreaDTO;

import java.util.List;
import java.util.Map;

public interface AreaDao {
    List<Map<String, Object>> children(String parentCode) throws Exception;

    Map<String, Object> queryByAreaCode(String areaCode) throws Exception;

    void update(AreaDTO areaDTO, String areaCode) throws Exception;
}
