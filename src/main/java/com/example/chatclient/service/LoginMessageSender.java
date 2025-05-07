package com.example.chatclient.service;

import com.example.chatclient.model.Message;
import com.example.chatclient.protocol.MessageType;
import io.netty.channel.Channel;

public class LoginMessageSender implements MessageSender {
    private final String userId;
    private final String password;

    public LoginMessageSender(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public void send(Channel channel) {
        Message login = new Message();
        login.setType(MessageType.LOGIN_REQUEST);
        login.setSender(userId);
        login.setContent(password);
        channel.writeAndFlush(login);
    }
}
