package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    private final EmailService emailService;
    private UserRepository userDao;
    public HelloController(EmailService emailService, UserRepository userDao) {
        this.emailService = emailService;
        this.userDao =userDao;
    }

    @GetMapping("/hello")
    public String hello(Model model){
       return "hello";
    }

//    @GetMapping("/hello")
//    @ResponseBody
//    public String hello(){return "<h1>Hello from Spring!</h1>";}
//
//    @RequestMapping(path = "/hello/{name}",method = RequestMethod.GET)
//    @ResponseBody
//
//    public String addOne(@PathVariable String name){
//        return String.format("Nice to meet you, %s!", name);
//    }
//    String fizzbuzzEvaluation(int num){
//        if(num % 3==0 && num% 5 == 0){
//            return "Fizzbuzz";
//        } else if (num % 3 == 0) {
//            return "Fizz";
//        }else if (num % 5 == 0){
//            return "Buzz";
//        }else{
//            return String.format("%d",num);
//        }
//    }
//    @GetMapping ("/number/and/{num}")
//    @ResponseBody
//    public String reportNumber(@PathVariable int num){
//      String intro=  String.format("Here are some truths of the number %d",num);
//      String isEven = String.format("The number %d is even: %b",num, num%2 ==0);
//      String numSquared = String.format("The number %d squared is %d",num,(int)Math.pow(num,2));
//      String fizzBuzzEval = String.format("The number %d when run through Fizzbuzz would print %s",num, fizzbuzzEvaluation(num));
//      return String.format("<h3>%s</h3><ul><li>%s</li><li>%s</li><li>%s</li></ul>",intro,isEven,numSquared,fizzBuzzEval);
//    }

    @GetMapping("/hello/{name}")
    public String sayHello(@PathVariable String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
