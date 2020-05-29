package test.framework.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.util.stream.Collectors.joining;

public class FileReader {

    public String readFile(String file){

        try {
            return Files.lines(
                    Paths.get("src/main/resources/" + file))
                    .collect(joining("\n" ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // note: a much safer alternative is to return Optional<>, and not null
        // see courses: "Working with Nulls in Java" and "Defensive Coding in Java"
        return null;
    }

}
