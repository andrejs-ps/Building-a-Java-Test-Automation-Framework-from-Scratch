package com.framework;

import com.testframework.reader.FileReader;
import com.testframework.reader.FileUtils;

public class ReaderTest {

    public static void main(String[] args) {

        String fileContent = FileUtils.readFile("SomeFile.txt");

        String moreContent = new FileReader().readFile("SomeFile.txt");

    }
}
