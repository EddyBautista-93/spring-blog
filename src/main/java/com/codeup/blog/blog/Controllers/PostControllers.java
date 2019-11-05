package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Struct;

@Controller
public class PostControllers {

    @GetMapping("/post")
    @ResponseBody
    public String index(){
        return"post index";
    }
}
