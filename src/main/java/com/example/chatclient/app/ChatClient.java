package com.example.chatclient.app;

import com.example.chatclient.codec.MessageDecoder;
import com.example.chatclient.codec.MessageEncoder;
import com.example.chatclient.model.Message;
import com.example.chatclient.protocol.MessageType;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatClient {
    @Autowired
    private ChatClientInitializer chatClientInitializer;
    private Channel channel;
    private EventLoopGroup group;

    public void start(String host, int port) throws InterruptedException {
        group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(chatClientInitializer);

        channel = bootstrap.connect(host, port).sync().channel();
    }

    public void stop() {
        if (group != null) {
            group.shutdownGracefully();
        }
    }

    public Channel getChannel() {
        return channel;
    }
}
