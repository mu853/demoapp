package com.my.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("hello", "Hello World!");
        return "hello";
    }

    @PostMapping("/logout")
    public String logout(Model model) {
        model.addAttribute("hello", "Hello World!");
        return "hello";
    }
}
