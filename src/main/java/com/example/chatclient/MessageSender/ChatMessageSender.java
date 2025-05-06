package com.example.chatclient.MessageSender;

import com.example.chatclient.model.Message;
import com.example.chatclient.protocol.MessageType;
import io.netty.channel.Channel;

public class ChatMessageSender implements MessageSender {
    private final String userId;
    private final String roomId;
    private final String content;

    public ChatMessageSender(String userId, String roomId, String content) {
        this.userId = userId;
        this.roomId = roomId;
        this.content = content;
    }

    @Override
    public void send(Channel channel) {
        Message chat = new Message();
        chat.setType(MessageType.MESSAGE);
        chat.setSender(userId);
        chat.setRoomId(roomId);
        chat.setContent(content);
        channel.writeAndFlush(chat);
    }
}
