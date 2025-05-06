package com.example.chatclient.model;

import com.example.chatclient.protocol.MessageType;
import com.example.chatclient.protocol.StatusCode;
import lombok.Data;

@Data
public class Message {
    private MessageType type;
    private StatusCode status;
    private String sender;
    private String roomId;
    private String content;
    private long timestamp;
    public Message() {
        this.timestamp = System.currentTimeMillis(); // 自动设置时间戳
    }
}