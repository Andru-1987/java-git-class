package com.client.client_api.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.client.client_api.services.ArtistsHttpClientService;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping("/httpclient")
public class ArtistsHttpClientController {

    @Autowired
    ArtistsHttpClientService artiststHttpService;

    public ArtistsHttpClientController(ArtistsHttpClientService service) {
        this.artiststHttpService = service;
    }

    @GetMapping("/getAllArtists")
    public JsonNode getAllArtists(@RequestParam(value = "page", required = false) Integer page)
            throws URISyntaxException, IOException, InterruptedException {
        JsonNode response = this.artiststHttpService.getAllArtists(page);
        return response;
    }

}
