package com.pruebajr.prueba.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class MovieResponse {
    public boolean adult;

    @JsonProperty("backdrop_path")
    public String backdropPath;

    @JsonProperty("genre_ids")
    public ArrayList<Integer> genreIds = new ArrayList<>();

    public int id;

    @JsonProperty("original_language")
    public String originalLanguage;

    @JsonProperty("original_title")
    public String originalTitle;

    public String overview;

    public Double popularity;

    @JsonProperty("poster_path")
    public  String posterPath;

    @JsonProperty("release_date")
    public String releaseDate;

    public String title;

    public boolean video;

    @JsonProperty("vote_average")
    public double voteAverage;

    @JsonProperty("vote_count")
    public int voteCount;
}
