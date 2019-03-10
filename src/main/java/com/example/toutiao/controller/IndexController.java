package com.example.toutiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gary on 2019-03-10
 */
@Controller
public class IndexController {

    @RequestMapping(path = {"/", "/index"})
    @ResponseBody
    public String index() {
        return "Hello Spring Boot";
    }

    @RequestMapping(path = {"/profile/{groupId}/{userId}"})
    @ResponseBody
    public String profile(@PathVariable("groupId") String groupId,
                          @PathVariable("userId") int userId,
                          @RequestParam(value = "type", defaultValue = "1") int type,
                          @RequestParam(value = "key", defaultValue = "spring boot") String key) {
        return String.format("GID{%s}, UID{%d}, TYPE{%d}, KEY{%s}", groupId, userId, type, key);
    }

    @RequestMapping(path = {"/ftl"})
    public String news() {
        return "news";
    }
}
