package com.udacity.file_upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam("attach")MultipartFile[] files)
    {
        boolean error = false;
        for (MultipartFile file: files)
        {
        System.out.println("fileName: " + file.getOriginalFilename());
        System.out.println("fileType: " + file.getContentType());

        String path = "D:\\Java Udacity\\file_upload\\src\\main\\resources\\static\\images\\";

        try {
            file.transferTo(new File(path + file.getOriginalFilename()));
        } catch (IllegalStateException e) {
            error = true;
            e.printStackTrace();
        } catch (IOException e) {
           error = true;
            e.printStackTrace();
        }
    }
        if(error)
            return "error uploading file";
        else

            return "file uploded sucessfully";



        
    }
}
