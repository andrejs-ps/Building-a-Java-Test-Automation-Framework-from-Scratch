package framework.java11httpclient;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static java.net.http.HttpClient.newBuilder;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Java11GetHeaderTestRefactored {

    private static final String BASE_URL = "https://api.github.com/";

    static HttpClient httpClient = newBuilder().build();
    static HttpResponse<Void> response;


    @BeforeAll
    static void sendGetToBaseEndpoint() throws IOException, InterruptedException {
        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 HttpClient Bot")
                .build();

        // Act - send request
        response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
    }

    @ParameterizedTest
    @CsvSource({
            "X-Ratelimit-Limit,60",
            "content-type,application/json; charset=utf-8",
            "server,GitHub.com",
            "x-frame-options,deny"
    })
    void parametrizedTestForHeaders(String header, String expectedValue) {

        String contentType = response.headers().firstValue(header).get();
        assertEquals(expectedValue, contentType);
    }

    @Test
    void getReturns200() throws IOException, InterruptedException {

        // Arrange
        HttpClient httpClient = HttpClient.newBuilder().build();

        HttpRequest get = HttpRequest.newBuilder(URI.create(BASE_URL))
                .setHeader("User-Agent", "Java 11 Http bot")
                .build();

        // Act
        HttpResponse<Void> response = httpClient.send(get, HttpResponse.BodyHandlers.discarding());
        int actualCode = response.statusCode();

        // Assert
        assertEquals(200, actualCode);

    }

}
