package com.bdp.project.area.controller;

import com.bdp.project.area.dto.AreaDTO;
import com.bdp.project.area.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/area")
public class AreaController {

    @Autowired
    private AreaService service;

    @GetMapping("/children/{parentCode}")
    public List<Map<String,Object>> children(@PathVariable("parentCode") String parentCode)throws Exception{
        return  service.children(parentCode);
    }


    @GetMapping("/queryByAreaCode/{areaCode}")
    public Map<String,Object> queryByAreaCode(@PathVariable("areaCode") String areaCode)throws Exception{
        return  service.queryByAreaCode(areaCode);
    }

    @GetMapping("/queryDtoByAreaCode/{areaCode}")
    public AreaDTO queryDtoByAreaCode(@PathVariable("areaCode") String areaCode)throws Exception{
        return  service.queryDtoByAreaCode(areaCode);
    }


    @GetMapping("/update")
    public Map<String,Object> queryDtoByAreaCode()throws Exception{
        AreaDTO areaDTO =  new AreaDTO();
        areaDTO.setAreaName("贵阳市11");
        areaDTO.setParentCode("52");
        return  service.update(areaDTO,"5201");
    }
}
