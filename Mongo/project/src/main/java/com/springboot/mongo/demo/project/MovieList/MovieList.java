package com.springboot.mongo.demo.project.movieList;

import java.util.List;

import com.springboot.mongo.demo.project.movie.Movie;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document("movieLists")
public class MovieList {

    @Id
    private String id;

    private String name;

    @CreatedDate
    private String createdDate;

    @DocumentReference
    private List<Movie> movies;

    public MovieList(String id, String name, String createdDate, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.movies = movies;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieList [createdDate=" + createdDate + ", id=" + id + ", name=" + name + "]";
    }
}
