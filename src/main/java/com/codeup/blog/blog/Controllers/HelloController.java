package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "<h1>hello</h1>";
    }

        @GetMapping("/hello/{name}")
        @ResponseBody
        public String sayHelloWithName(@PathVariable String name) {
            return "Hello " + name + "!";

    }



}
