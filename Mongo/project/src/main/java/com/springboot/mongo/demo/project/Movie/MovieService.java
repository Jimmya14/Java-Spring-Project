package com.springboot.mongo.demo.project.movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(String id) {
        Optional<Movie> result = movieRepository.findById(id);

        if (result.isPresent()) {
            Movie movie = result.get();

            return movie;
        } else {
            throw new MovieNotFoundException("movie not found");
        }
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        Movie movie = this.getMovieById(id);

        movieRepository.delete(movie);
    }
}
