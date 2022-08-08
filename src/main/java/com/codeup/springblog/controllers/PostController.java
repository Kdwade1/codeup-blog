package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.User;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {
    private  final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao){
        this.postDao=postDao;
        this.userDao = userDao;
    }
    @GetMapping("/posts")
     public String all(Model model) {
        List<Post> all = postDao.findAll();
        model.addAttribute("posts", all);
        return "post/index";
    }


    @GetMapping("/post/show/{id}")
    public String postId(@PathVariable long id, Model model) {
//        ArrayList<Post> post = new ArrayList<>();
//        post.add(new Post(1, "title", "body"));
//        post.add(new Post(2,"hello","kndefkjadsfbkjfsdbdfs"));
        model.addAttribute("post",postDao.getById(id));
        return "post/show";
    }

    @GetMapping("/post/create")
    public String showCreate(Model model){
        model.addAttribute("post",new Post());
        return "/post/create";
    }

    @PostMapping("/post/create")
    public String create(@ModelAttribute Post post) {
     postDao.save(post);
        return "redirect:/posts";}

    @GetMapping("/posts/{id}/edit")
    public String editPost(Model model, @PathVariable long id){
        model.addAttribute("post",postDao.getById(id));
        return "redirect:/posts";
    }

//    @GetMapping("/post/create")
//    public String showUserForm(Model model, PostRepository postDao) {
//        model.addAttribute("posts",postDao.findAll());
//        return "post/create";
//    }
//
//    @PostMapping("/post/create")
//    public String submitUserForm(@RequestParam(name="post")long id, @RequestParam(name="title")String title, PostRepository postDao) {
//        User newUser = new User();
//        newUser.setPosts((List<Post>) postDao.getById(id));
//        return "redirect:/posts";
//    }

}
