package com.codeup.blog.blog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Controller
public class HelloController {


    @GetMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "<h1>hello</h1>";
    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {

        ArrayList<String> students = new ArrayList<>();
        students.add("eddy");
        students.add("boby");
        students.add("Frank");
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        model.addAttribute("students", students);
        return "join";
    }



    @GetMapping("/roll-dice/{number}")
    public String guessingGame(@RequestParam(name= "number") String number, Model x){

        int randomNum = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        Integer numberGussed = Integer.valueOf(number);
        if(numberGussed.equals(randomNum)){

        }


       return null;
    }


}
