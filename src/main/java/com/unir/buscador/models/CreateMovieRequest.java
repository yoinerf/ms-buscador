package com.unir.buscador.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateMovieRequest {
    private String id_Movie;
    private String name;
    private String synopsis;
    private List<GenreModel> genres;
    private String releaseDate;
    private String poster;
    private String trailer;
    private String director;
    private int duration;


}
