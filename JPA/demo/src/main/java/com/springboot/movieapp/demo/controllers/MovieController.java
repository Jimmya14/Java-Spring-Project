package com.springboot.movieapp.demo.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.springboot.movieapp.demo.models.Movie;
import com.springboot.movieapp.demo.services.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;
    
    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movieId}")
    public Movie getMovieById(@PathVariable int movieId){
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/")
    public Movie addMovie(@RequestBody Movie movie) {

        System.out.println(movie);
        movieService.addMovie(movie);

        return movie;
    }

    @DeleteMapping("/{movieId}")
    public Map<String, String> deleteMovie(@PathVariable int movieId) {
        movieService.deleteMovie(movieId);

        Map<String, String> result = Collections.singletonMap("response", "Success");

        return result;
    }
    
}
