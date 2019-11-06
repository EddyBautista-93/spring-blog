package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Array;
import java.sql.Struct;
import java.util.ArrayList;

@Controller
public class PostControllers {

    @GetMapping("/")
    public String index(){
        return "/post/index";
    }

    @PostMapping("/show")
    public String showPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String desc, Model x){
        ArrayList<Post> userPost = new ArrayList<>();

        userPost.add(new Post("Dog","Its a dog"));
        userPost.add(new Post("car","Its a cat"));
        userPost.add(new Post(title,desc));
        x.addAttribute("post", userPost);
        return "/post/show";
    }
}
