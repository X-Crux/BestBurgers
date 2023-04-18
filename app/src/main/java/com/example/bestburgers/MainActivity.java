package com.example.bestburgers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import com.example.bestburgers.api.model.Article;
import com.example.bestburgers.api.model.ArticleObjectDTO;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.functions.BiConsumer;

public class MainActivity extends AppCompatActivity {

    CompositeDisposable disposable = new CompositeDisposable();
    RecyclerView recyclerView;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.news_list);
        adapter = new Adapter();

        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        App app = (App) getApplication();
        disposable.add(app.getNewsService().getApi().getArticleObjectDTO()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BiConsumer<ArticleObjectDTO, Throwable>() {
                    @Override
                    public void accept(ArticleObjectDTO articleObjectDTO, Throwable throwable) throws Exception {
                        if (throwable != null) {
                            Toast.makeText(MainActivity.this, "Data loading error", Toast.LENGTH_SHORT).show();
                        } else {
                            adapter.setArticles(articleObjectDTO.getArticles());
                        }
                    }
                }));
    }

    public void pageBurgerStart(View v) {
        Intent intent = new Intent(this, page1.class);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }

    private class Adapter extends RecyclerView.Adapter<ViewHolder> {

        List<Article> articles = new ArrayList<>();

        public void setArticles(List<Article> articles) {
            this.articles.clear();
            this.articles = articles;
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_article, viewGroup, false));
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.bind(articles.get(i));
        }

        @Override
        public int getItemCount() {
            return articles.size();
        }
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        Article articleDTO;
        TextView text;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
            text.setTextColor(Color.WHITE);
        }

        public void bind(Article article) {
            articleDTO = article;
            text.setText(article.getTitle());
        }
    }
}