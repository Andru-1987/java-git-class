package com.client.client_api.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.client.client_api.services.ArtistsRestTemplateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resttemplate")
public class ArtistRestTemplateController {

    private final ArtistsRestTemplateService artistsService;

    @Autowired
    public ArtistRestTemplateController(ArtistsRestTemplateService artistsService) {
        this.artistsService = artistsService;
    }

    @GetMapping("/getAllArtists")
    public ResponseEntity<JsonNode> getArtists(@RequestParam(required = false) Integer page) {
        try {
            JsonNode response = artistsService.getPost(page);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
