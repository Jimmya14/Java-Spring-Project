package com.springboot.mongo.demo.project.MovieList;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.springboot.mongo.demo.project.Movie.Movie;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movielist")
public class MovieListController {
    private MovieListService movieListService;

    public MovieListController(MovieListService movieListService) {
        this.movieListService = movieListService;
    }

    @GetMapping("/")
    public List<MovieList> getAllMovieLists() {
        return movieListService.getAll();
    }

    @GetMapping("/{movieListId}")
    public MovieList getMovieListById(@PathVariable String movieListId) {
        return movieListService.getMovieListById(movieListId);
    }

    @PostMapping("/")
    public MovieList addMovieList(@RequestBody MovieList movieList) {
        movieListService.addMovieList(movieList);

        return movieList;
    }

    @DeleteMapping("/{movieListId}")
    public Map<String, String> deleteMovieList(@PathVariable String movieListId) {
        movieListService.deleteMovieList(movieListId);

        Map<String, String> result = Collections.singletonMap("response", "Success");

        return result;
    }

    @PutMapping("/addMovie/{movieListId}/{movieId}")
    public Map<String, String> addMovie(@PathVariable String movieListId, @PathVariable String movieId) {

        movieListService.addMovie(movieListId, movieId);

        Map<String, String> result = Collections.singletonMap("response", "Success");

        return result;
    }

    @PutMapping("/deleteMovie/{movieListId}/{movieId}")
    public Map<String, String> deleteMovie(@PathVariable String movieListId, @PathVariable String movieId) {

        movieListService.deleteMovieById(movieId, movieListId);

        Map<String, String> result = Collections.singletonMap("response", "Success");

        return result;
    }

    @GetMapping("/getListsOrdered")
    public List<MovieList> getOrdered(@RequestParam String order) {

        return movieListService.getMovieListsOrdered(order);
    }

    @GetMapping("/getMovies/{movieListId}")
    public List<Movie> getMovies(@PathVariable String movieListId) {

        return movieListService.getMoviesFromList(movieListId);
    }

    @GetMapping("/mostMovies")
    public Map<String, String> mostMovies() {

        Map<String, String> result = Collections.singletonMap("name", movieListService.mostMovies());

        return result;
    }
}
