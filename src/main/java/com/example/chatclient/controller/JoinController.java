package com.example.chatclient.controller;

import com.example.chatclient.service.JoinRoomSender;
import com.example.chatclient.app.ChatClient;
import io.netty.channel.Channel;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.Map;

@Controller
@RequestMapping("/rooms")
public class JoinController {
    ChatClient client = new ChatClient();

    @PostMapping("/join")
    public String joinRoom(
            @RequestBody Map<String, String> requestBody, // 仅修改这一行
            HttpSession session,
            RedirectAttributes redirectAttributes) {

        // 保持原有逻辑开始
        String roomId = requestBody.get("roomId"); // 从map获取参数
        String username = (String) session.getAttribute("username");

        if (username == null) {
            redirectAttributes.addFlashAttribute("error", "请先登录");
            return "redirect:/login";
        }

        try {
            JoinRoomSender sender = new JoinRoomSender(username, roomId);
            Channel channel=(Channel) session.getAttribute("channel");
            sender.send(channel);

            session.setAttribute("currentRoom", roomId);
            redirectAttributes.addFlashAttribute("success", "成功加入房间: " + roomId);

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "房间加入失败: " + e.getMessage());
        }

        return "redirect:/chat";
        // 保持原有逻辑结束
    }
}