package com.testframework.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class FileUtils {

    public static String readFile(String file){

        try {
            return Files.lines(
                    Paths.get("src/main/resources/" + file))
                    .collect(joining("\n" ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
