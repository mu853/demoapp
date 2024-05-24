package com.my.demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    final List<Message> messages = new CopyOnWriteArrayList<>();

    @GetMapping("message")
    public List<Message> getMessage() {
        return messages;
    }

    @PostMapping("messages")
    public Message postMessages(@RequestBody Message message) {
        messages.add(message);
        return message;
    }
}
