package com.springboot.movieapp.demo.dao;

import java.util.List;

import com.springboot.movieapp.demo.models.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie,Integer>{
    
    List<Movie> findByMovieListId(int movieListId);
    
    @Query("SELECT m.movieList, COUNT(m.movieList) as occurrence FROM Movie m GROUP BY m.movieList ORDER BY occurrence DESC")
    List<Object[]> findMostMovies();
}

