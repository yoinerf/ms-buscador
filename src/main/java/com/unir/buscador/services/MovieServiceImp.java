package com.unir.buscador.services;

import com.unir.buscador.models.CreateMovieRequest;
import com.unir.buscador.models.GenreModel;
import com.unir.buscador.models.MovieModel;

import org.springframework.beans.factory.annotation.Autowired;
import com.unir.buscador.repositories.DataAccessRepository;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class MovieServiceImp implements MoviesService {

    @Autowired
    private DataAccessRepository repository;

    @Override
    public List<MovieModel> getMovies(String name, String synopsis, String director, String genres) {
        List<MovieModel> movies = repository.findMovies(name, synopsis, director, genres);
        return movies.isEmpty() ? null : movies;
    }

    @Override
    public MovieModel getMovie(String movie_id) {
        return repository.findById(movie_id).orElse(null);
    }


    @Override
    public MovieModel createMovie(CreateMovieRequest request)  {
        MovieModel movie = new MovieModel();
        movie.setId(request.getId_Movie());
        movie.setName(request.getName());
        movie.setSynopsis(request.getSynopsis());
        movie.setReleaseDate(request.getReleaseDate());
        movie.setPoster(request.getPoster());
        movie.setTrailer(request.getTrailer());
        movie.setDirector(request.getDirector());
        movie.setDuration(String.valueOf(request.getDuration()));

        List<GenreModel> genres = new ArrayList<>();
        for (GenreModel movieGenre : request.getGenres()) {
            Optional<GenreModel> optionalGenre = repository.findGenreById(movieGenre.getId());
            if (optionalGenre.isPresent()) {
                GenreModel genre = optionalGenre.get();
               // genre.setName(movieGenre.getName());
                genres.add(genre);
            } else {
                throw new RuntimeException("Género no encontrado");
            }
        }
        movie.setGenres(genres);
        return repository.save(movie);

    }

    @Override
    public Boolean removeMovie(String movie_id) {

        MovieModel movie = repository.findById(movie_id).orElse(null);

        if (movie != null) {
            repository.delete(movie);
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }
}