package com.unir.buscador.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.unir.buscador.models.CreateMovieRequest;
import com.unir.buscador.models.MovieModel;

import java.util.List;

public interface MoviesService {

    List<MovieModel> getMovies(String name, String synopsis, String director, String genres);

    MovieModel getMovie(String movie_Id);

    Boolean removeMovie(String movie_Id);

    MovieModel createMovie(CreateMovieRequest request) throws JsonProcessingException;

}
