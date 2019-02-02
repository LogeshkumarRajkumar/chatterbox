package com.chat;

import java.util.*;

public class Chat {

    private String chatContentUrl;
    private FileReader fileReader;

    public Chat(String url, FileReader reader) {
        this.chatContentUrl = url;
        this.fileReader = reader;
    }

    public List<String> getTopChatters(int limit) {
        List<String> chatsByPerson = fileReader.readFromUrl(chatContentUrl);
        HashMap<String, Integer> chatFrequency = getChatFrequency(chatsByPerson);
        List<Map.Entry<String, Integer>> sortedChatFrequency = sortToList(chatFrequency);

        return getTopChatters(limit, sortedChatFrequency);
    }

    private HashMap<String, Integer> getChatFrequency(List<String> chatsByPerson) {
        HashMap<String, Integer> chatFrequency = new HashMap();
        for (int i = 0; i < chatsByPerson.size(); i++) {
            String name = chatsByPerson.get(i).split(":")[0];
            if (chatFrequency.containsKey(name)) {
                chatFrequency.put(name, chatFrequency.get(name) + 1);
            } else {
                chatFrequency.put(name, 1);
            }
        }
        return chatFrequency;
    }

    private static List<Map.Entry<String, Integer>> sortToList(HashMap<String, Integer> hm) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(hm.entrySet());

        Collections.sort(list, Comparator.comparing(o -> (o.getValue())));

        return list;
    }

    private List<String> getTopChatters(int limit, List<Map.Entry<String, Integer>> sortedChatFrequency) {
        List<String> topChatters = new ArrayList<>();
        for (int i = sortedChatFrequency.size() - 1; i > sortedChatFrequency.size() - 1 - limit; i--) {
            topChatters.add(sortedChatFrequency.get(i).getKey());
        }
        return topChatters;
    }
}
