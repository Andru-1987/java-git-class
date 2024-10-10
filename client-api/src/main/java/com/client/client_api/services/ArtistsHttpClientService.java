package com.client.client_api.services;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ArtistsHttpClientService {

    @Value("${getendpoint}")
    private String getEndPoint;

    @Value("${postendpoint}")
    private String postEndPoint;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getAllArtists(Integer page) throws URISyntaxException, IOException, InterruptedException {

        if (page == null) {
            page = 1;
        }

        System.out.println("The end point: " + getEndPoint);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(getEndPoint + "?page=" + page))
                .version(HttpClient.Version.HTTP_2)
                .GET()
                .timeout(Duration.of(10, ChronoUnit.SECONDS))
                .build();

        HttpClient client = HttpClient.newBuilder().build();

        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse.statusCode());

        JsonNode jsonResponse = objectMapper.readTree(httpResponse.body());

        return jsonResponse;

    }



}
