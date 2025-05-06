package com.example.chatclient.app;

import com.example.chatclient.codec.MessageDecoder;
import com.example.chatclient.codec.MessageEncoder;
import com.example.chatclient.model.Message;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.ChannelHandlerContext;

public class ChatClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) {
        ch.pipeline()
                .addLast(new MessageDecoder())
                .addLast(new MessageEncoder())
                .addLast(new SimpleChannelInboundHandler<Message>() {
                    @Override
                    protected void channelRead0(ChannelHandlerContext ctx, Message msg) {
                        System.out.println("[客户端接收] " + msg);
                    }
                });
    }
}
