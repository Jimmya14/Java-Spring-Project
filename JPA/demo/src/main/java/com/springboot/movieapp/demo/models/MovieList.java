package com.springboot.movieapp.demo.models;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="movieList")
@EntityListeners(AuditingEntityListener.class)
public class MovieList {

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

    @Column(name="name")
    private String name;

    @Column(name="createdDate")
    @CreatedDate
    private Date createdDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "movieList")
    private List<Movie> movies;

    public MovieList() {
    }

    public MovieList(int id, String name, Date createdDate, List<Movie> movies) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.movies = movies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
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
        return "MovieList [createdDate=" + createdDate + ", id=" + id + /* ", moviesId=" + moviesId + */ ", name=" + name
                + "]";
    }
    
}
