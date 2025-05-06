package com.example.chatclient.MessageSender;

import io.netty.channel.Channel;

public interface MessageSender {
    void send(Channel channel);
}
