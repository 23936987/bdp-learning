package com.bdp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class TestController {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public String hello(){
       return "hello";
    }


    @GetMapping("/list")
    public  List<Map<String,Object>> list(){

        List<Map<String,Object>> list = jdbcTemplate.queryForList("select id,name from user");

        return list;
    }
}
