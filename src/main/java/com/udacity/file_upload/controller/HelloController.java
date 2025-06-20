package com.udacity.file_upload.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    
    Map<String,Object> result = new HashMap<>();

    @RequestMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello()
    {
        result.put("name", "Ahmed");
        result.put("city", "fayoum");

        return result;
    }

}
