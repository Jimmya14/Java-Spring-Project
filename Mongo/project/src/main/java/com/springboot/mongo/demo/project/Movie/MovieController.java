package com.springboot.mongo.demo.project.Movie;

import java.util.List;

import com.springboot.mongo.demo.project.Global.MessageResponse;

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
    public Movie getMovieById(@PathVariable String movieId) {
        return movieService.getMovieById(movieId);
    }

    @PostMapping("/")
    public Movie addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);

        return movie;
    }

    @DeleteMapping("/{movieId}")
    public MessageResponse deleteMovie(@PathVariable String movieId) {
        movieService.deleteMovie(movieId);

        return  new MessageResponse("success");
    }

}
