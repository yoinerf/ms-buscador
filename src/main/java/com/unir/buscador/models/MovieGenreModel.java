package com.unir.buscador.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "moviegenre", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieGenreModel {

    @Id
    private String id;

    @Field(type = FieldType.Text, name = "movie")
    private MovieModel movie;

    @Field(type = FieldType.Text, name = "genre")
    private GenreModel genre;

    }