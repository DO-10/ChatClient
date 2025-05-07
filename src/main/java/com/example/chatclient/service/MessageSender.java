package com.example.chatclient.service;

import io.netty.channel.Channel;

public interface MessageSender {
    void send(Channel channel);
}
