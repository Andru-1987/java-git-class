package com.client.client_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.client_api.services.ArtistsWebClientService;
import com.fasterxml.jackson.databind.JsonNode;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webclient")
public class ArtistWebClientController {

    private final ArtistsWebClientService artistsService;

    @Autowired
    public ArtistWebClientController(ArtistsWebClientService artistsService) {
        this.artistsService = artistsService;
    }

    @GetMapping("/getAllArtists")
    public Mono<ResponseEntity<JsonNode>> getAllArtists(@RequestParam(required = false) Integer page) {

        return this.artistsService.getAllArtists(page)
                .map(response -> ResponseEntity.ok(response))
                .onErrorResume(e -> {
                    // Log the error if needed
                    return Mono.just(ResponseEntity.internalServerError().body(null));
                });
    }

}