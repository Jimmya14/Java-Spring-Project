package com.springboot.mongo.demo.project.movie;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class Movie {

    @Id
    private String id;

    private String title;

    private Genre genre;

    private String releaseDate;

    private String directorName;

    public Movie(String id, String title, Genre genre, String releaseDate, String directorName) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "Movie [directorName=" + directorName + ", genre=" + genre + ", id=" + id + ", releaseDate="
                + releaseDate + ", title=" + title + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Movie m = (Movie) obj;
        if (this.getId().equals(m.getId())) {
            return true;
        } else {
            return false;
        }
    }
}
