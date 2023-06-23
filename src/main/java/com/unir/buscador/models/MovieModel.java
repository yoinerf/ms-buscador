package com.unir.buscador.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.List;
import java.util.Map;

@Document(indexName = "movies", createIndex = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MovieModel {

    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Keyword, name = "name"),otherFields = @InnerField(
            suffix = "search", type=  FieldType.Search_As_You_Type))
    private String name;

    @Field(type = FieldType.Text, name = "synopsis")
    private String synopsis;

    @Field(type = FieldType.Nested, name = "genres")
    //private Map<ElasticGenre, Object> genres;
    private List<GenreModel> genres;

    @Field(type = FieldType.Keyword, name = "releaseDate")
    private String releaseDate;

    @Field(type = FieldType.Text, name = "poster")
    private String poster;

    @Field(type = FieldType.Text, name = "trailer")
    private String trailer;

    @Field(type = FieldType.Text, name = "director")
    private String director;

    @Field(type = FieldType.Integer, name = "duration")
    private String duration;


}
