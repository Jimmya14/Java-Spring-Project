package com.springboot.movieapp.demo.services;

import java.util.List;
import java.util.Optional;

import com.springboot.movieapp.demo.dao.*;
import com.springboot.movieapp.demo.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieListService {
    
    private MovieListRepository movieListRepository;
    private MovieRepository movieRepository;

    @Autowired
    public MovieListService(MovieListRepository movieListRepository, MovieRepository movieRepository) {
        this.movieListRepository = movieListRepository;
        this.movieRepository = movieRepository;
    }

    public List<MovieList> getAll() {
        return movieListRepository.findAll();
    }

    public MovieList getMovieListById(int movieListId) {
        Optional<MovieList> result = movieListRepository.findById(movieListId);

        if(result.isPresent()){
            MovieList movieList = result.get();

            return movieList;
        }else{
            throw new RuntimeException("Couldn't find that movie list");
        }
    }

    public void addMovieList(MovieList movieList){
        movieList.setId(0);
        movieListRepository.save(movieList);
    }

    public void deleteMovieList(int id){
        Optional<MovieList> result = movieListRepository.findById(id);

        if(result.isPresent()){
            movieListRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("could not find that movie list");
        }
    }

    // public void update(int id, MovieList movieList) {
    //     Optional<MovieList> result = movieListRepository.findById(id);

    //     if(result.isPresent()){
    //         MovieList oldMovieList = result.get();
    //         movieList.setId(id);
    //         movieList.setCreatedDate(oldMovieList.getCreatedDate());
    //         movieListRepository.save(movieList);
    //     }
    //     else {
    //         throw new RuntimeException("Couldn't find that movie list");
    //     }
    // }

    public void addMovie(int movieId,int id){
        Optional<MovieList> result = movieListRepository.findById(id);
        Optional<Movie> result2 = movieRepository.findById(movieId);

        if(result.isPresent() && result2.isPresent()){
            MovieList movieList = result.get();
            Movie movie = result2.get();

            List<Movie> m = movieList.getMovies();
            m.add(movie);
            movieList.setMovies(m);

            movie.setMovieList(movieList);

            movieRepository.save(movie);
        }
        else{
            throw new RuntimeException("Couldn't find that movie list");
        }
    }

    public MovieList deleteMovieById(int movieId, int listId){
        Optional<MovieList> result = movieListRepository.findById(listId);
        Optional<Movie> result2 = movieRepository.findById(movieId);

        if(result.isPresent() && result2.isPresent()){
            MovieList movieList = result.get();
            Movie movie = result2.get();

            List<Movie> m = movieList.getMovies();
            m.remove(movie);
            movieList.setMovies(m);

            movie.setMovieList(null);

            movieRepository.save(movie);
            movieListRepository.save(movieList);

            return movieList;
        }else{
            throw new RuntimeException("Couldn't find that movie list or that movie");
        }
    }

    public List<MovieList> getMovieListsOrdered(String order){

        if(order.equals("name")){
            return movieListRepository.findByOrderByName();
        }
        else if(order.equals("creation date")){
            return movieListRepository.findByOrderByCreatedDate();
        }
        else {
            throw new RuntimeException("order field invalid");
        }
    }

    public List<Movie> getMoviesFromList(int id){
        Optional<MovieList> result = movieListRepository.findById(id);

        if(result.isPresent()){

            return movieRepository.findByMovieListId(id);
        }else{
            throw new RuntimeException("Couldn't find that movie list");
        }

    }

    public String mostMovies() {
        List<Object[]> result = movieRepository.findMostMovies();

        // for(Object [] obj : result){
        //     System.out.println(obj[0].toString() + "-" + obj[1].toString());
        // }

        MovieList m =(MovieList)result.get(0)[0];

        return m.getName();
    }
    
}