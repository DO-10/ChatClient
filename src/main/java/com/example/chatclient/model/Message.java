package com.example.chatclient.model;

import com.example.chatclient.protocol.MessageType;
import com.example.chatclient.protocol.StatusCode;
import lombok.Data;

import java.util.List;

@Data
public class Message {
    private MessageType type;
    private StatusCode status;
    private String sender;
    private String roomId;
    private String content;
    private long timestamp;
    private List<String> users;
    public Message() {
        this.timestamp = System.currentTimeMillis(); // 自动设置时间戳
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public  String getSender() {
        return sender;
    }
    public MessageType getType() {
        return type;
    }
    public void setType(MessageType type) {
        this.type = type;
    }
    public StatusCode getStatus() {
        return status;
    }
    public void setStatus(StatusCode status) {
        this.status = status;
    }
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    public List<String> getUsers() {
        return users;
    }
    public void setUsers(List<String> users) {
        this.users = users;
    }
}