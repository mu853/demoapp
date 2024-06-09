package com.my.demo;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("messages")
    public String getMessage(Model model) {
        List<Message> messages = messageRepository.findAll();
        model.addAttribute("messages", messages);
        return "messages";
    }

    @PostMapping("messages")
    public String postMessages(Message message) {
        messageRepository.save(message);
        return "redirect:messages";
    }
}
