package com.example.chatclient.controller;

import com.example.chatclient.config.GetHttpSessionConfigurator;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/message", configurator = GetHttpSessionConfigurator.class)
@Component
public class ChatEndPoint {

    public static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();
    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        String username = (String) this.httpSession.getAttribute("username");
//        System.out.println("用户名："+ username);
        onlineUsers.put("1",session);
        System.out.println("session is online"+onlineUsers);
        String a = "{\"username\":\"System\", \"message\":\"Welcome to the chat room!\"}";
        session.getBasicRemote().sendText(a);

    }

    @OnMessage
    public void onMessage(String message) {

    }
    @OnClose
    public void onClose(Session session) {
        // Handle the close event
//        String id = (String) this.httpSession.getAttribute("id");
//        onlineUsers.remove(id);
        System.out.println("User "  + " has left the chat.");
    }
}
