package institute.immune.newsapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ArticleSaved extends AppCompatActivity {

    private RecyclerView rvarticle;
    private Button btn_news, btn_saved;
    private Guardadas guardadadb;
    private GuardadasService guardadasLab;
    private ArrayList<Guardadas> guardadasList, guardadastotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_saved);
        init();
        generateData();
        btn_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        btn_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateData();
            }
        });
    }

    private void init(){
        guardadasList = new ArrayList<>();
        this.rvarticle = findViewById(R.id.recyclerview);
        btn_news = findViewById(R.id.btn_news);
        btn_saved = findViewById(R.id.btn_saved);
        guardadasLab = GuardadasService.get(this);
        guardadastotal = (ArrayList<Guardadas>) guardadasLab.getGuardadas();
    }

    private void generateData(){
        for (int i = 0; i < guardadastotal.size(); i++){
            Guardadas guardadas = guardadastotal.get(i);
            guardadasList.add(new Guardadas(guardadas.getAuthor(), guardadas.getTitle(), guardadas.getDescription(), guardadas.getUrl(), guardadas.getUrlToImage(), guardadas.getPublishedAt(), guardadas.getContent(), guardadas.getId()));
        }
        rvarticle.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        rvarticle.setAdapter(new GuardadasAdapter(getBaseContext(), guardadasList));
    }
}