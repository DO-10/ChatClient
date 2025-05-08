package com.example.chatclient.controller;

import com.example.chatclient.service.LoginMessageSender;
import com.example.chatclient.app.ChatClient;
import io.netty.channel.Channel;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private ChatClient client;
    @GetMapping
    public String login() {
        return "login"; // 返回登录页面的视图名称
    }
    @PostMapping
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        // 这里可以添加登录逻辑，比如验证用户名和密码
        // 如果登录成功，重定向到聊天页面
        // 如果登录失败，返回登录页面并显示错误信息

        LoginMessageSender loginMessageSender = new LoginMessageSender(username, password);
        try {
            client.start("localhost", 8080); // 启动客户端连接到服务器
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "login"; // 登录失败，返回登录页面
        }
        Channel channel = client.getChannel();
        loginMessageSender.send(channel);
        //需要解析服务器响应结果
        session.setAttribute("username", username);
        session.setAttribute("channel", channel);
        return "redirect:/chat"; // 登录成功后重定向到聊天页面

    }

}
