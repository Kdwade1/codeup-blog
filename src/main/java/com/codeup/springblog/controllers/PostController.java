package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/post")
    @ResponseBody
    public String post(){return "Posting..";}

    @GetMapping("/post/{id}")
    @ResponseBody
    public String postId(@PathVariable String id){return String.format("This is your id: %s",id);}

    @GetMapping("/post/create")
    @ResponseBody
    public String postCreate(){return "Posting..and Creating...";}

    @PostMapping("/post/create")
    @ResponseBody
    public String posts(){return "Here what I posted";}

}
