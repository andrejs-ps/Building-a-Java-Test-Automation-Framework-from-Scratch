package framework.java11httpclient;

import com.testframework.entities.FailedAuthentication;
import com.testframework.handlers.JsonBodyHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java11PostFails {

    private static final String BASE_URL = "https://api.github.com/";

    @Test
    void postWithoutAuthorizationFails() throws IOException, InterruptedException {
        // Arrange - create client
        HttpClient httpClient = newBuilder().build();

        // Arrange - create request
        HttpRequest post = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .setHeader("credentials", "web token or password")
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();


        // Act - send request
        HttpResponse<Void> response = httpClient.send(post, HttpResponse.BodyHandlers.discarding());
        int actualCode = response.statusCode();

        // Assert
        assertEquals(401, actualCode);
    }

    @Test
    void postFailsContainsMessage() throws IOException, InterruptedException {

        // Arrange - create client
        HttpClient httpClient = newBuilder().build();

        // Arrange - create request
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL + "user/repos"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .build();



        HttpResponse<FailedAuthentication> response = httpClient.send(get, JsonBodyHandler.jsonBodyHandler(FailedAuthentication.class));

        String actualMessage = response.body().getMessage();

        Assertions.assertEquals("Requires authentication", actualMessage);
    }
}
