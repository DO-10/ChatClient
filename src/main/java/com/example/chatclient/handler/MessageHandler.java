package com.example.chatclient.handler;

import com.example.chatclient.model.Message;
//import com.example.chatclient.service.WebSocketMessageRender;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import com.example.chatclient.protocol.MessageType;

@Component
public class MessageHandler extends SimpleChannelInboundHandler<Message> {
//    @Autowired
//    WebSocketMessageRender webSocketMessageRender;
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Message msg) {
        System.out.println("[客户端接收] " + msg);
        System.out.println("客户端接收"+msg.getType());
        if(msg.getType()==MessageType.INFORMATION){
            System.out.println(msg.getUsers());
        }
        if(msg.getType()==MessageType.MESSAGE){
            System.out.println(msg.getContent());
        }
        // 渲染接收到的消息
//        webSocketMessageRender.render(msg);
//        System.out.println("[客户端渲染] " + msg);
    }
}
