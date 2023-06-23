package com.unir.buscador.repositories;

import com.unir.buscador.models.MovieGenreModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieGenreRepository extends ElasticsearchRepository<MovieGenreModel, String> {

}
