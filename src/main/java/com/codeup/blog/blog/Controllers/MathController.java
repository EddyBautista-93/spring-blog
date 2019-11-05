package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String add(@PathVariable int num1, @PathVariable int num2){
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @GetMapping("/subtract/{x}/from/{y}")
    @ResponseBody
    public String Subtract(@PathVariable int x,@PathVariable int y ){
        return x + " - " + y + " = " + (x - y);
    }

    @GetMapping("/multiply/{x}/and/{y}")
    @ResponseBody
    public String Multiply(@PathVariable int x,@PathVariable int y ){
        return x + " x " + y + " = " + (x * y);
    }


    @GetMapping("/divide/{x}/by/{y}")
    @ResponseBody
    public String Divide(@PathVariable int x,@PathVariable int y ){
        return x + " / " + y + " = " + (x / y);
    }

}
