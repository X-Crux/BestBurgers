package com.example.bestburgers.api.model;

import java.util.List;

public class ArticleObjectDTO {

    private List<Article> articles;
    private String status;
    private Integer totalResults;

    public List<Article> getArticles() {
        return articles;
    }
    public String getStatus() {
        return status;
    }
    public Integer getTotalResults() {
        return totalResults;
    }

}
