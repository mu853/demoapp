package com.my.demo;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    MessageRepository messageRepository;

    @GetMapping("messages")
    public List<Message> getMessage(Model model) {
        return messageRepository.findAll();
    }

    @PostMapping("messages")
    public Message postMessages(Message message) {
        messageRepository.save(message);
        return message;
    }
}
