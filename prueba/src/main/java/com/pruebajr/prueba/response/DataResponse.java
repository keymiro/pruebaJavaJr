package com.pruebajr.prueba.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class DataResponse {

    @JsonProperty ("page")
    public int page;

    @JsonProperty ("results")
    public ArrayList<MovieResponse> results = new ArrayList<>();

    @JsonProperty ("total_pages")
    public int totalPages;

    @JsonProperty ("total_results")
    public int totalResults;

}
