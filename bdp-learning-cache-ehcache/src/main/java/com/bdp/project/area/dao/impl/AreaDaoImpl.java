package com.bdp.project.area.dao.impl;

import com.bdp.project.area.dao.AreaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AreaDaoImpl implements AreaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Map<String, Object>> children(String parentCode) throws Exception {


        String sql = "select area_code areaCode,area_name areaName from sys_area where parent_code=:parentCode";
        Map<String,Object> wheres = new HashMap<>();
        wheres.put("parentCode",parentCode);

        System.out.println("sql:"+sql);
        return namedParameterJdbcTemplate.queryForList(sql,wheres);
    }
}
