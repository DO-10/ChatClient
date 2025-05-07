package com.example.chatclient.controller;

import com.example.chatclient.model.Message;
import com.example.chatclient.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@Controller
public class TestPushController {

    @GetMapping("/test-push")
    public String push() {
        return "chat";
    }
}
