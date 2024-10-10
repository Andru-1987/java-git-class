package com.client.client_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.client_api.configs.WebClientBean;
import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

@Service
public class ArtistsWebClientService {

    private final WebClientBean webClient;

    @Autowired
    public ArtistsWebClientService(WebClientBean webClient) {
        this.webClient = webClient;
    }

    public Mono<JsonNode> getAllArtists(Integer page) {

        if (page == null) {
            page = 1;
        }

        return this.webClient.webClient().get()
                .uri("?page=" + page)
                .retrieve()
                .bodyToMono(JsonNode.class);

    }
    // public Mono<String> createArtist(String artistJson) {
    // return this.webClient.post()
    // .uri("/artists") // Replace with the correct path if needed
    // .bodyValue(artistJson)
    // .retrieve()
    // .bodyToMono(String.class); // Return the response body as a String
    // }

}
