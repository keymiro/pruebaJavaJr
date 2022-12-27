package com.pruebajr.prueba.service;

import com.pruebajr.prueba.response.DataResponse;
import com.pruebajr.prueba.response.MovieResponse;

public interface IMovieService {
    DataResponse getMovies(int page);
    MovieResponse getDetails(int movie_id);
}
