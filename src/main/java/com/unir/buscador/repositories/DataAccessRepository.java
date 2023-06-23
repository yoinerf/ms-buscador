package com.unir.buscador.repositories;

import java.util.List;
import java.util.Optional;

import com.unir.buscador.models.GenreModel;
import com.unir.buscador.models.MovieModel;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder.Type;
import org.elasticsearch.index.query.QueryBuilders;

import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Repository
@RequiredArgsConstructor
@Slf4j
public class DataAccessRepository {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final ElasticsearchOperations elasticClient;

    private final String[] textSearchFields = { "name.search", "name.search._2gram", "name.search._3gram" };

    public MovieModel save(MovieModel movie) {
        return movieRepository.save(movie);
    }

    public Boolean delete(MovieModel movie) {
        return movieRepository.delete(movie);
    }
//    public Boolean delete(MovieModel movie) {
//        movieRepository.delete(movie);
//        return Boolean.TRUE;
//    }

    public List<MovieModel> findProducts(String name, String synopsis, String director, String genres) {

        BoolQueryBuilder querySpec = QueryBuilders.boolQuery();

        if (!StringUtils.isEmpty(name)) {
            //querySpec.must(QueryBuilders.matchQuery("name", name));
            querySpec.must(QueryBuilders.multiMatchQuery(name, textSearchFields).type(Type.BOOL_PREFIX));
        }

        if (!StringUtils.isEmpty(synopsis)) {
            querySpec.must(QueryBuilders.matchQuery("synopsis", synopsis));
            //querySpec.must(QueryBuilders.multiMatchQuery(synopsis, synopsisSearchFields).type(Type.BOOL_PREFIX));
        }

        if (!StringUtils.isEmpty(director)) {
            querySpec.must(QueryBuilders.termQuery("director", director));
        }

        if (!StringUtils.isEmpty(genres)) {
            querySpec.must(QueryBuilders.matchQuery("genres", genres));
        }

        //para que coincida con todos
        if (!querySpec.hasClauses()) {
            querySpec.must(QueryBuilders.matchAllQuery());
        }

        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder().withQuery(querySpec);

        Query query = nativeSearchQueryBuilder.build();
        SearchHits<MovieModel> result = elasticClient.search(query, MovieModel.class);

        return result.getSearchHits().stream().map(SearchHit::getContent).toList();
    }

    public Optional<MovieModel> findById(String id) {
        return movieRepository.findById(id);
    }

    public Optional<GenreModel> findGenreById(String id) {
        return genreRepository.findById(id);
    }
}
