package com.example.toutiao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String news(Model model) {
        model.addAttribute("value1", "This is a trial");
        List<String> colors = Arrays.asList(new String[] {"Red", "Green", "Blue"});
        model.addAttribute("colors", colors);

        Map<String, String> mapping = new HashMap<String, String>();
        for(int i=0; i<4; i++){
            mapping.put(String.valueOf(i), String.valueOf(i*i));
        }
        model.addAttribute("map", mapping);
        return "news";
    }
}
