package com.example.chatclient.mapper;

import jakarta.websocket.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserRoomMapper {
    public static final Map<String, String> userRoomMapper = new ConcurrentHashMap<String, String>();
}
