package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String diceRoll() {
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{n}")
    public String getDieRoll(@PathVariable int n, Model model) {
        int roll = (int) Math.floor(Math.random() * 6) + 1;
        model.addAttribute("n", String.format("The number is %d", n));
        model.addAttribute("roll", String.format("You're roll is %d", roll));
        if (n == roll) {
            model.addAttribute("answer", "You unfortunately win");
        } else {
            model.addAttribute("answer", "HAHAHAHA you lose");

        }
        return "/roll-dice";


    }
}
