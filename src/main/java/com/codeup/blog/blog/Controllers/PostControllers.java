package com.codeup.blog.blog.Controllers;

import com.codeup.blog.blog.Repo.PostRepository;
import com.codeup.blog.blog.Repo.UserRepository;
import com.codeup.blog.blog.models.EmailService;
import com.codeup.blog.blog.models.Post;
import com.codeup.blog.blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostControllers {

    private final PostRepository postDao;
    private final UserRepository userDao;


    public PostControllers(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;

    }
        @Autowired
        EmailService emailService;


    @GetMapping("/")
    public String index() {
        return "/post/index";
    }

    @GetMapping("/show")
    public String index(Model x) {
        x.addAttribute("posts", postDao.findAll());
//        x.addAttribute("user", userDao.getOne(id));
        return "/post/show";
    }

//    @GetMapping("/show/{id}")
//    public String show(@PathVariable long id, Model viewModel){
//        viewModel.addAttribute("post", postDao.getOne(id));
//        viewModel.addAttribute("user", userDao.getOne(id));
//        return "post/iPost";
//    }




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
    public String showCreateForm(Model vModel){
        vModel.addAttribute("post",new Post());
        return "post/create";
    }

    @PostMapping("/show/create")
    public String create(@ModelAttribute Post postToBeCreated) {
        postToBeCreated.setUser(userDao.getOne(1L));
         postDao.save(postToBeCreated);

        emailService.prepareAndSend(postToBeCreated, "add created", "a add has been created and the id attached to said ad is  "+ postToBeCreated.getId());
        return "redirect:/show/";

    }


}
