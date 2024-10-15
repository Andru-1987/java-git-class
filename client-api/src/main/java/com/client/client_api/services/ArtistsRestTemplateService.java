package com.client.client_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.client.client_api.configs.RestBean;
import com.client.client_api.models.Artist;
import com.client.client_api.responses.ApiResponse;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ArtistsRestTemplateService {

    private RestBean restTemplate;

    @Value("${getendpoint}")
    private String getEndPoint;

    @Autowired
    public ArtistsRestTemplateService(RestBean restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JsonNode getPost(Integer page) {

        if (page == null) {
            page = 1;
        }

        String url = getEndPoint + "?page=" + page;
        ResponseEntity<JsonNode> response = this.restTemplate
                .restTemplate()
                .getForEntity(url, JsonNode.class);

        return response.getBody();
    }

    public Optional<List<Artist>> getAllArtistsNoJson(Integer page) {

        if (page == null) {
            page = 1;
        }

        String url = getEndPoint + "?page=" + page;

        ResponseEntity<ApiResponse> response = this.restTemplate.restTemplate().getForEntity(url, ApiResponse.class);

        return Optional.ofNullable(response.getBody())
                .map(ApiResponse::getPaginatedArtists);

    }

}