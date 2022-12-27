package com.pruebajr.prueba;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import com.pruebajr.prueba.response.DataResponse;
import com.pruebajr.prueba.response.MovieResponse;
import com.pruebajr.prueba.service.MovieService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class MovieApiTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void testGetAllMovies() {
        // Arrange
        int page = 1;

        DataResponse mockResponse = new DataResponse();

        // Configura el objeto mockResponse con la información de las películas esperada
        when(restTemplate.getForObject("/api/v1/movies", DataResponse.class)).thenReturn(mockResponse);
        // Act
        DataResponse response = movieService.getMovies(page);
        // Assert
        assertNotNull(response);
        assertEquals(mockResponse, response);
    }
    @Test
    public void testGetDetailsMovie() {
        // Arrange
        int movie_id = 315162;

        MovieResponse mockResponse = new MovieResponse();

        // Configura el objeto mockResponse con la información de las películas esperada
        when(restTemplate.getForObject("/api/v1/movies/"+ movie_id, MovieResponse.class)).thenReturn(mockResponse);
        // Act
        MovieResponse response = movieService.getDetails(movie_id);
        // Assert
        assertNotNull(response);
        assertEquals(mockResponse, response);
    }
}

