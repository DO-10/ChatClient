package com.example.chatclient.service;

import com.example.chatclient.model.Message;
import com.example.chatclient.protocol.MessageType;
import io.netty.channel.Channel;

public class JoinRoomSender implements MessageSender {
    private final String userId;
    private final String roomId;

    public JoinRoomSender(String userId, String roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    @Override
    public void send(Channel channel) {
        Message join = new Message();
        join.setType(MessageType.JOIN_ROOM);
        join.setSender(userId);
        join.setRoomId(roomId);
        channel.writeAndFlush(join);
    }
}
