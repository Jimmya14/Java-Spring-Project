package com.springboot.movieapp.demo.dao;

import java.util.List;

import com.springboot.movieapp.demo.models.MovieList;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieListRepository extends JpaRepository<MovieList,Integer>{
    
    List<MovieList> findByOrderByName();
    List<MovieList> findByOrderByCreatedDate();

    
    // MovieList findTopByOrderByMoviesDesc();

}