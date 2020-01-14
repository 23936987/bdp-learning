package com.bdp.project.area.service;

import java.util.List;
import java.util.Map;

public interface AreaService {
    List<Map<String, Object>> children(String parentCode) throws Exception;
}
