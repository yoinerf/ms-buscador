package com.unir.buscador.controllers;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.unir.buscador.models.CreateMovieRequest;
import com.unir.buscador.models.MovieModel;
import com.unir.buscador.services.MoviesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MovieController {

    private final MoviesService service;

    //OBTENER POR ID
    @GetMapping("/movies/{movie_id}")
    public ResponseEntity<MovieModel> getMovieById(@PathVariable String movie_id) {

        MovieModel movieModel = service.getMovie(movie_id);
        if (movieModel != null) {
            return ResponseEntity.ok(movieModel);
        } else {
            return ResponseEntity.notFound().build();
        }

    }




    //OBTENER TODOS
    @GetMapping("/movies")
    public ResponseEntity<List<MovieModel>>getMovies(
             @RequestHeader Map<String, String> headers,
             @RequestParam(required = false) String name,
             @RequestParam(required = false) String synopsis,
             @RequestParam(required = false) String director,
             @RequestParam(required = false) String genres){

        List<MovieModel> movies = service.getMovies(name, synopsis, director, genres);

        return ResponseEntity.ok(Objects.requireNonNullElse(movies, Collections.emptyList()));
//
    }

    //CREAR
    @PostMapping("/movies")
    public ResponseEntity<MovieModel> createMovie(@RequestBody CreateMovieRequest request) throws JsonProcessingException {


        MovieModel createdMovieModel = service.createMovie(request);

        if (createdMovieModel != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdMovieModel);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }



    //ELIMINAR
    @DeleteMapping("/movies/{movie_Id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable String movie_Id) {

        Boolean removed = service.removeMovie(movie_Id);

        if (Boolean.TRUE.equals(removed)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

//    //ACTUALIZAR
//    @PutMapping ("/movies/{movie_Id}")
//    public MovieModel updateMovieById(@RequestBody MovieModel request,@PathVariable String movie_Id){
//        return this.service.(request, movie_Id);
//    }



}

