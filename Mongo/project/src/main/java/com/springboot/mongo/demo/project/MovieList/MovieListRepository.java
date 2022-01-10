package com.springboot.mongo.demo.project.movieList;

import java.util.List;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieListRepository extends MongoRepository<MovieList, String> {

    List<MovieList> findByOrderByName();

    List<MovieList> findByOrderByCreatedDate();

    @Aggregation(pipeline = { "{$unwind: '$movies'}",
            "{$group: {_id: '$_id', name: {$first: '$name'}, number: {$sum: 1}}}", "{$sort: {number:-1}}",
            "{$limit: 1}", "{$project: {_id:0, name:1}}" })
    Object[] findMostMovies();
}
