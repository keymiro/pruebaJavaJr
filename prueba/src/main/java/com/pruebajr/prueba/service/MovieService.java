package com.pruebajr.prueba.service;

import com.pruebajr.prueba.response.DataResponse;
import com.pruebajr.prueba.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
@Component
public class MovieService implements IMovieService {

    @Value("${movies.base-url}")
    public String basePath;

    @Value("${movies.api-key}")
    public String apiKey;

    private RestTemplate restTemplate;

    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public DataResponse getMovies(int page) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(basePath + "/popular")
                .queryParam("api_key", apiKey)
                .queryParam("page", page);

        String url = builder.build().encode().toUriString();

        return restTemplate.getForObject(url, DataResponse.class);
    }

    public MovieResponse getDetails(int movie_id) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(basePath + "/" + movie_id)
                .queryParam("api_key", apiKey);

        String url = builder.build().encode().toUriString();

        return restTemplate.getForObject(url, MovieResponse.class);
    }

}
