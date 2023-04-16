package com.example.bestburgers.api;

import com.example.bestburgers.api.model.ArticleDTO;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsApi {

    @GET("v2/top-headlines")
    Single<List<ArticleDTO>> getArticles();

}
