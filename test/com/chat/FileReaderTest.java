package com.chat;

import org.junit.Test;

import java.io.File;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class FileReaderTest {

    @Test
    public void shouldReturnContentOfFileAsListOfStrings() {
        FileReader reader = new FileReader();
        List<String> contents = reader.readFromUrl(new File("./test/TestFile.txt").toURI().toString());
        assertTrue(contents.size() == 2);
        assertTrue(contents.get(0).equals("testdata1"));
        assertTrue(contents.get(1).equals("testdata2"));
    }

    @Test
    public void shouldReturnNullWhenFileIsNotFound() {
        FileReader reader = new FileReader();
        List<String> contents = reader.readFromUrl(new File("tests/TestFile.txt").toURI().toString());
        assertTrue(contents == null);
    }
}
