package com.springboot.movieapp.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="movie")
public class Movie {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    private String title;

    @Column(name="genre")
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column(name="releaseDate")
    private String releaseDate;

    @Column(name="directorName")
    private String directorName;

    @JsonBackReference
    @ManyToOne
    private MovieList movieList;

    public Movie() {
    }

    public Movie(int id, String title, Genre genre, String releaseDate, String directorName, MovieList movieList) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
        this.movieList = movieList;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
    public MovieList getMovieList() {
        return movieList;
    }

    public void setMovieList(MovieList movieList) {
        this.movieList = movieList;
    }

    @Override
    public String toString() {
        return "Movie [directorName=" + directorName + ", genre=" + genre + ", id=" + id + ", movieList=" + movieList
                + ", releaseDate=" + releaseDate + ", title=" + title + "]";
    }


    
}
