package com.chat;

import java.net.URL;
import java.util.*;

public class FileReader{

    public List<String> readFromUrl(String url){
        List<String> content = new ArrayList<>();
        try {
            URL fileUrl = new URL(url);
            Scanner scanner = new Scanner(fileUrl.openStream());

            while (scanner.hasNext())
                content.add(scanner.nextLine());

        } catch (Exception e) {
            System.out.println("Exception :" + e.getMessage());
            return null;
        }
        return content;
    }
}
