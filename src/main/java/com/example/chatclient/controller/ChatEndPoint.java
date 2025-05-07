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

    private static final Map<String, Session> onlineUsers = new ConcurrentHashMap<>();
    private HttpSession httpSession;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//        String id = (String) this.httpSession.getAttribute("id");
//        onlineUsers.put(id,session);
        String a = "{\"username\":\"System\", \"message\":\"Welcome to the chat room!\"}";
        session.getBasicRemote().sendText(a);

    }

    @OnMessage
    public void onMessage(String message) {

    }
    @OnClose
    public void onClose(Session session) {
        // Handle the close event
        String id = (String) this.httpSession.getAttribute("id");
        onlineUsers.remove(id);
        System.out.println("User " + id + " has left the chat.");
    }
}
