package institute.immune.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private Articles articledb;
    private ArticleService articleLab;
    private ArrayList<Articles> articlesList;
    private RecyclerView rvNews;
    private Button btn_news, btn_saved, btn_buscar;
    private EditText txt_buscar;
    private String q;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        generateData("a");
        btn_buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                q = txt_buscar.getText().toString();
                if (q != null && !q.isEmpty()) {
                    generateData(q);
                } else {
                    generateData("a");
                }
            }
        });
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateData("a");
            }
        });


        btn_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), ArticleSaved.class);
                startActivity(intent);
            }
        });
    }

    private void init(){
        articlesList = new ArrayList<>();
        rvNews = findViewById(R.id.recyclerview);
        articleLab = ArticleService.get(this);
        btn_news = findViewById(R.id.btn_news);
        btn_saved = findViewById(R.id.btn_saved);
        btn_buscar = findViewById(R.id.btn_buscar);
        txt_buscar = findViewById(R.id.txt_buscar);
    }

    private void generateData(String q) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://newsapi.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        NewsApi newsApi = retrofit.create(NewsApi.class);
        articlesList.clear();
        Call<New> news = newsApi.getNew(q, "d2c7864645174cbe970358d919eba552");

        news.enqueue(new Callback<New>() {
            @Override
            public void onResponse(Call<New> call, Response<New> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getBaseContext(), "Problemas causados: " + response.code(), Toast.LENGTH_LONG).show();
                    return;
                }

                List<Articles> body = response.body().getArticles();

                 for (Articles article : body) {
                    articlesList.add(new Articles(article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt(), article.getContent()));
                    articledb = new Articles(article.getAuthor(), article.getTitle(), article.getDescription(), article.getUrl(), article.getUrlToImage(), article.getPublishedAt(), article.getContent());
                    articleLab.addArticle(articledb);
                 }
                 rvNews.setLayoutManager(new LinearLayoutManager(getBaseContext()));
                 rvNews.setAdapter(new NewAdapter(getBaseContext(), articlesList));
            }

            @Override
            public void onFailure(Call<New> call, Throwable t) {
                Toast.makeText(getBaseContext(), "Problemas graves: " + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.i("Error", t.getLocalizedMessage());
            }
        });

    }
}