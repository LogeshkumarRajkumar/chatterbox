package com.chat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChatTest {
    @Test
    public void getTopChattersShouldReturnTopChatters(){
        List<String> content = new ArrayList<>();
        content.add("<a>:a");
        content.add("<b>:a");
        content.add("<a>:a");
        FileReader fileReader = mock(FileReader.class);
        Chat chat= new Chat("url", fileReader);
        when(fileReader.readFromUrl("url")).thenReturn(content);

        List<String> topChatters = chat.getTopChatters(2);
        assertTrue(topChatters.size() == 2);
        assertTrue(topChatters.get(0).equals("<a>"));
        assertTrue(topChatters.get(1).equals("<b>"));
    }
}
