package test.framework.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.stream.Collectors.joining;

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
