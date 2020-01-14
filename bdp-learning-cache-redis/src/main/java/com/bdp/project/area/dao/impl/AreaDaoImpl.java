package com.bdp.project.area.dao.impl;

import com.bdp.project.area.dao.AreaDao;
import com.bdp.project.area.dto.AreaDTO;
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

    @Override
    public Map<String, Object> queryByAreaCode(String areaCode) throws Exception {
        String sql = "select area_code areaCode,area_name areaName from sys_area where area_code=:areaCode";
        Map<String,Object> wheres = new HashMap<>();
        wheres.put("areaCode",areaCode);

        System.out.println("sql:"+sql);
        return namedParameterJdbcTemplate.queryForMap(sql,wheres);
    }

    @Override
    public void update(AreaDTO areaDTO, String areaCode) throws Exception {
        String sql = "update sys_area set area_name=:areaName  where area_code=:areaCode";
        Map<String,Object> wheres = new HashMap<>();
        wheres.put("areaCode",areaCode);
        wheres.put("areaName",areaDTO.getAreaName());
        namedParameterJdbcTemplate.update(sql,wheres);
    }
}
