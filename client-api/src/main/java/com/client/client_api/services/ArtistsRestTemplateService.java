package com.client.client_api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.client.client_api.configs.RestBean;
import com.fasterxml.jackson.databind.JsonNode;

@Service
public class ArtistsRestTemplateService {

    @Autowired
    private RestBean restTemplate;

    @Value("${getendpoint}")
    private String getEndPoint;

    public JsonNode getPost(Integer page) {

        if (page == null) {
            page = 1;
        }

        String url = getEndPoint + "?page=" + page;
        ResponseEntity<JsonNode> response = restTemplate.restTemplate().getForEntity(url, JsonNode.class);
        return response.getBody();
    }
}