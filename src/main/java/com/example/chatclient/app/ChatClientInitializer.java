package com.example.chatclient.app;

import com.example.chatclient.codec.MessageDecoder;
import com.example.chatclient.codec.MessageEncoder;
import com.example.chatclient.handler.MessageHandler;
import com.example.chatclient.model.Message;
//import com.example.chatclient.service.WebSocketMessageRender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandlerContext;

 @Component// 确保这个类被 Spring 管理
public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    @Autowired
    MessageHandler messageHandler;
    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline()
                .addLast(new MessageDecoder())
                .addLast(new MessageEncoder())
                .addLast(messageHandler);
    }
}