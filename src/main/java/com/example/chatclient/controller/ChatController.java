package com.example.chatclient.controller;

import com.example.chatclient.mapper.UserRoomMapper;
import com.example.chatclient.service.ChatMessageSender;
import com.example.chatclient.service.JoinRoomSender;
import io.netty.channel.Channel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chat")
public class ChatController {
    @GetMapping
    public String chatPage() {
        return "chat"; // 返回聊天页面的视图名称
    }
    @PostMapping
    public String sendMessage(@RequestParam String message, HttpSession session) {
        ChatMessageSender chatMessageSender = new ChatMessageSender((String) session.getAttribute("username"),(String) session.getAttribute("currentRoom"), message);// 处理发送的消息
        chatMessageSender.send((Channel) session.getAttribute("channel"));
        // 这里可以添加逻辑，比如将消息发送到服务器
        // 然后返回聊天页面
        return "redirect:/chat"; // 重定向到聊天页面
    }
    @GetMapping("/join")
    public String joinRoom(@RequestParam String roomId, HttpSession session) {
        // 这里可以添加逻辑，比如加入聊天室
        UserRoomMapper.userRoomMapper.put(roomId,(String) session.getAttribute("username"));
        System.out.println("【命令行战士】"+ UserRoomMapper.userRoomMapper);
        JoinRoomSender joinRoomSender = new JoinRoomSender("1", roomId);
        joinRoomSender.send((Channel) session.getAttribute("channel"));
        // 然后返回聊天页面
        return "redirect:/chat"; // 重定向到聊天页面
    }
}
