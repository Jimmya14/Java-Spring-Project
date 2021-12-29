package com.springboot.movieapp.demo.services;

import java.util.List;
import java.util.Optional;

import com.springboot.movieapp.demo.dao.MovieRepository;
import com.springboot.movieapp.demo.models.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie getMovieById(int id){
        Optional<Movie> result = movieRepository.findById(id);

        if(result.isPresent()){
            Movie movie = result.get();

            return movie;
        }else {
            throw new RuntimeException("could not find that movie");
        }
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public void addMovie(Movie movie){
        movie.setId(0);

        movieRepository.save(movie);
    }

    public void deleteMovie(int id){
        Optional<Movie> result = movieRepository.findById(id);

        if(result.isPresent()){
            movieRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("could not find that movie");
        }
    }
}
