package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class PostControllers {

    private PostRepository postDao;
    private Post post;

    public PostControllers(PostRepository postDao) {
        this.postDao = postDao;
    }

    @GetMapping("/")
    public String index() {
        return "/post/index";
    }

//    @PostMapping("/ads")
//    public String showPost(@RequestParam(name = "title") String title, @RequestParam(name = "description") String desc, @RequestParam(name = "id") int id, Model x){
//        ArrayList<Post> userPost = new ArrayList<>();
//        userPost.add(new Post(id,title,desc));
//        x.addAttribute("post", postDao.findAll());
//        return "/post/show";
//    }

    @GetMapping("/show")
    public String showPost(Model x) {
        x.addAttribute("post", postDao.findAll());
        return "/post/show";
    }


    @GetMapping("show/{id}/edit")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        return "/post/edit";
    }

    @PostMapping("/show/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String description) {
        Post oldAd = postDao.getOne(id);
        oldAd.setTitle(title);
        oldAd.setDescription(description);
        postDao.save(oldAd);
        return "redirect:/show/";
    }

    @PostMapping("/show/{id}/delete")
    public String delete(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/show/";
    }
}