package com.client.client_api.responses;

import java.util.List;

import com.client.client_api.models.Artist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int page;
    private int pageSize;
    private int totalPages;
    private int totalArtists;
    private List<Artist> paginatedArtists;

}
