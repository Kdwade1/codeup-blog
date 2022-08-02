package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{num}/and/{numb}")
    @ResponseBody
  public int add(@PathVariable int num,@PathVariable int numb){return num + numb;}


    @GetMapping("/subtract/{num}/from/{numb}")
    @ResponseBody
    public int subtract(@PathVariable int num,@PathVariable int numb){return num - numb;}

    @GetMapping("/multiply/{num}/and/{numb}")
    @ResponseBody
    public int multiply(@PathVariable int num,@PathVariable int numb){return num * numb;}

    @GetMapping("/divide/{num}/by/{numb}")
    @ResponseBody
    public int divide(@PathVariable int num,@PathVariable int numb){return num / numb;}
}
