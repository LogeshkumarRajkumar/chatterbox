package com.chat;

import com.chat.Chat;

import java.util.List;

public class ChatApplication {
    public static void main(String[] args) {
        Chat c = new Chat("https://s3.ap-south-1.amazonaws.com/haptikinterview/chats.txt", new FileReader());
        List<String> topChatters = c.getTopChatters(3);
        System.out.println("Result:");
        for (int i = 0; i < 3; i++) {
            System.out.println(topChatters.get(i));
        }
    }
}
