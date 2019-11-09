package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Repo.PostRepository;
import com.codeup.blog.blog.Repo.UserRepository;
import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostControllers {

    private PostRepository postDao;
    private UserRepository userDao;
    private Post post;
    private User user;

    public PostControllers(PostRepository postDao) {
        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/")
    public String index() {
        return "/post/index";
    }

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

    @GetMapping("/show/create")
    public String showCreateForm(){
        return "post/create";
    }

    @PostMapping("/show/create")
    public String create(@RequestParam String title, @RequestParam String body){
        Post post = postDao.save(new Post(title, body));
        return "redirect:/show/" + post.getId();
    }




}