package com.springboot.mongo.demo.project.MovieList;

import java.util.List;
import java.util.Optional;

import com.springboot.mongo.demo.project.Movie.Movie;
import com.springboot.mongo.demo.project.Movie.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieListService {

    private MovieListRepository movieListRepository;

    private MovieService movieService;

    @Autowired
    public MovieListService(MovieListRepository movieListRepository, MovieService movieService) {
        this.movieListRepository = movieListRepository;
        this.movieService = movieService;
    }

    public List<MovieList> getAll() {
        return movieListRepository.findAll();
    }

    public MovieList getMovieListById(String id) {
        Optional<MovieList> result = movieListRepository.findById(id);

        if (result.isPresent()) {
            return result.get();
        } else {
            throw new MovieListNotFoundException("could not find movie list");
        }
    }

    public void addMovieList(MovieList movieList) {
        movieListRepository.save(movieList);
    }

    public void deleteMovieList(String id) {
        MovieList movieList = this.getMovieListById(id);

        movieListRepository.delete(movieList);
    }

    public MovieList addMovie(String id, String movieId) {

        MovieList movieList = this.getMovieListById(id);

        Movie movie = movieService.getMovieById(movieId);

        List<Movie> list = movieList.getMovies();
        list.add(movie);
        movieList.setMovies(list);

        movieListRepository.save(movieList);

        return movieList;
    }

    public MovieList deleteMovieById(String movieId, String listId) {
        MovieList movieList = this.getMovieListById(listId);

        Movie movie = movieService.getMovieById(movieId);

        List<Movie> list = movieList.getMovies();
        list.remove(movie);
        movieList.setMovies(list);

        movieListRepository.save(movieList);

        return movieList;
    }

    public List<MovieList> getMovieListsOrdered(String order) {
        if (order.equals("name")) {
            return movieListRepository.findByOrderByName();
        } else if (order.equals("creation Date")) {
            return movieListRepository.findByOrderByCreatedDate();
        } else {
            throw new RuntimeException("order not valid");
        }
    }

    public List<Movie> getMoviesFromList(String id) {
        MovieList movieList = this.getMovieListById(id);

        return movieList.getMovies();
    }

    public String mostMovies() {
        Object[] test = movieListRepository.findMostMovies();

        return test[0].toString();
    }

}
