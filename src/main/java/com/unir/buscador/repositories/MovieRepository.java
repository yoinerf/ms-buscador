package com.unir.buscador.repositories;

import com.unir.buscador.models.MovieModel;

import java.util.List;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository<MovieModel, String> {
    List<MovieModel> findByName(String name);

    Optional<MovieModel> findById(String id);

    MovieModel save(MovieModel movie);

    void delete(MovieModel movie);

    List<MovieModel> findAll();

}
