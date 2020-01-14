package com.bdp.project.area.dao;

import java.util.List;
import java.util.Map;

public interface AreaDao {
    List<Map<String, Object>> children(String parentCode) throws Exception;
}
