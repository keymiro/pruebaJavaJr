package com.pruebajr.prueba.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pruebajr.prueba.request.MovieResquest;
import com.pruebajr.prueba.response.DataResponse;
import com.pruebajr.prueba.response.MovieResponse;
import com.pruebajr.prueba.service.IMovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/movies")
@RequiredArgsConstructor

@Api(value="movies", description="Operaciones relacionado con las peliculas")
public class MovieController {

    private IMovieService iMovieService;

    @Autowired
    public MovieController(IMovieService iMovieService) {
        this.iMovieService = iMovieService;
    }

    @GetMapping
    @ApiOperation(value = "Obtiene todas las movies paginadas en 20")
    public DataResponse getAll(
            @ApiParam(value = "page opcional", required = false)
            @RequestParam(value = "page", defaultValue = "1") int page) {
        return iMovieService.getMovies(page);
    }

    @PostMapping
    @ApiOperation(value = "Obtiene todas las movies paginadas en 20, pero con metodo POST")
    public DataResponse getAllMovies(
            @ApiParam(value = "page obligatorio", required = true)
            @RequestBody  MovieResquest page) {
        return iMovieService.getMovies(page.page);
    }

    @GetMapping("/{movie_id}")
    @ApiOperation(value = "Obtiene el detalle de una movie con el movie_id")
    public MovieResponse getDetailsMovie(
            @ApiParam(value = "{movie_id} de la pelicula, obligatorio", required = true)
            @PathVariable int movie_id) {
        return iMovieService.getDetails(movie_id);
    }
}

