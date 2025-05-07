//package com.example.chatclient.service;
//
//import com.example.chatclient.model.Message;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class WebSocketMessageRender implements MessageRender {
//    @Autowired
//    private SimpMessagingTemplate messagingTemplate;
//    @Override// 发送到订阅此话题的用户
//    public void render(Message message) {
//        System.out.println("【WebSocket 推送】发送消息到前端: " + message);
//        messagingTemplate.convertAndSend("/topic/messages", message);
//        System.out.println("slslsl");// 推送给订阅者
//    }
//}
//
