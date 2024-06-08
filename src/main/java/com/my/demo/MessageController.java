package com.my.demo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("message")
    public List<Message> getMessage() {
        return jdbcTemplate.query("SELECT name FROM items ORDER BY id", (rs, i) -> {
            Message m = new Message();
            m.setText(rs.getString("name"));
            return m;
        });
    }

    @PostMapping("messages")
    public Message postMessages(@RequestBody Message message) {
        jdbcTemplate.update("INSERT INTO items(name) VALUES (?)", message.getText());
        return message;
    }
}
