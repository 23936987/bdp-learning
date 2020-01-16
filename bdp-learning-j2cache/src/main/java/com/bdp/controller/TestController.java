package com.bdp.controller;

import com.bdp.entity.User;
import com.bdp.service.J2cacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    J2cacheService j2cacheService;

    @RequestMapping("/j2cache")
    public String j2cache(@RequestParam("key")String key, @RequestParam("value")String value){
        return j2cacheService.addCache(key,value);
    }

    @RequestMapping("/queryCache")
    public String queryRedis(@RequestParam("type")String type){
        return j2cacheService.queryCache(type);
    }

    @RequestMapping("/getKey")
    public String getKey(@RequestParam("key")String key){
        return j2cacheService.getKey(key);
    }

    @RequestMapping("/deleteKey")
    public String deleteKey(@RequestParam("key")String key){
        return j2cacheService.deleteKey(key);
    }



    @RequestMapping("/object_set")
    public String object_set(){
        return j2cacheService.object_set();
    }
    @RequestMapping("/object_get/{id}")
    public User object_get(@PathVariable("id")String id){
        return j2cacheService.object_get(id);
    }

}
