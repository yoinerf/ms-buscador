package com.unir.buscador.repositories;


import com.unir.buscador.models.GenreModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Optional;

public interface GenreRepository extends ElasticsearchRepository<GenreModel, String> {
    Optional<GenreModel> findById(String id);
}
