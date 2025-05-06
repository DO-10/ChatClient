package com.example.chatclient.app;

import com.example.chatclient.codec.MessageDecoder;
import com.example.chatclient.codec.MessageEncoder;
import com.example.chatclient.model.Message;
import com.example.chatclient.protocol.MessageType;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class ChatClient {
    private Channel channel;
    private EventLoopGroup group;

    public void start(String host, int port) throws InterruptedException {
        group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .handler(new ChatClientInitializer());

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
