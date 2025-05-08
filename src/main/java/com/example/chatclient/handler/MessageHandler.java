package com.example.chatclient.handler;

import com.example.chatclient.controller.ChatEndPoint;
import com.example.chatclient.mapper.UserRoomMapper;
import com.example.chatclient.model.Message;
//import com.example.chatclient.service.WebSocketMessageRender;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MessageHandler extends SimpleChannelInboundHandler<Message> {
//    @Autowired
//    WebSocketMessageRender webSocketMessageRender;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) throws EncodeException, IOException {
        System.out.println("[客户端接收] " + msg);
        System.out.println(ChatEndPoint.onlineUsers);
        System.out.println("接收者是"+msg.getReceiver());
        Session session = ChatEndPoint.onlineUsers.get(msg.getReceiver());
        session.getBasicRemote().sendText("{\"message\":\"你好呀\",\"warning\":\"我知道这不是你发送的消息的内容,我只是想向你证明web后端接收到了服务器的消息,并且可以成功发送到web客户端\"}");
//        session.getBasicRemote().sendObject(msg);
        // 渲染接收到的消息
//        webSocketMessageRender.render(msg);
//        System.out.println("[客户端渲染] " + msg);
    }
}
