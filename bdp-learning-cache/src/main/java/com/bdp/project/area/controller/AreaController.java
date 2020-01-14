package com.bdp.project.area.controller;

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


}
