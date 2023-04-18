package com.example.bestburgers.api.model;

public class Article {

    private String author;
    private String content;
    private String description;
    private String publishedAt;
    private Source source;
    private String title;
    private String url;
    private String urlToImage;

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }

    public String getDescription() {
        return description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public Source getSource() {
        return source;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }
}
