package com.example.chatclient.handler;

import com.example.chatclient.controller.ChatEndPoint;
import com.example.chatclient.model.Message;
//import com.example.chatclient.service.WebSocketMessageRender;
import com.example.chatclient.util.JsonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import com.example.chatclient.protocol.MessageType;

import java.io.IOException;
import java.util.Arrays;

@Component
public class MessageHandler extends SimpleChannelInboundHandler<Message> {
//    @Autowired
//    WebSocketMessageRender webSocketMessageRender;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws Exception {
        System.out.println("[客户端接收] " + msg);
        System.out.println("online"+ChatEndPoint.onlineUsers);
        System.out.println("接收者是"+msg.getReceiver());
        if(msg.getType()==MessageType.INFORMATION){
            System.out.println(msg.getUsers());
        }
        Session session = ChatEndPoint.onlineUsers.get(msg.getReceiver());
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(msg);

        session.getBasicRemote().sendText(json);
    }
}

