package institute.immune.newsapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewViewHolder> {

    private final Context context;
    private final ArrayList<Articles> articlesList;
    private ArticleService articleLab;
    private ImageView image;

    public NewAdapter(Context context, ArrayList<Articles> articlesList) {
        this.context = context;
        this.articlesList = articlesList;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_view, parent, false);
        image = view.findViewById(R.id.imagenicono);
        return new NewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {
        articleLab = ArticleService.get(this.context);
        Articles article = articlesList.get(position);
        holder.setTxt_author("by " + article.getAuthor());
        holder.setTxt_title(article.getTitle());
        if (article.getUrlToImage() == null) {
            holder.setImage("https://www.webempresa.com/foro/wp-content/uploads/wpforo/attachments/3200/318277=80538-Sin_imagen_disponible.jpg");
        }else {
            holder.setImage(article.getUrlToImage());
        }
        String fecha =  article.getPublishedAt();
        String[] fecha1 = fecha.split("T");
        String fecha_definitiva = fecha1[0];

        holder.setTxt_publishedAt(fecha_definitiva);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ArticleDetails.class);
                intent.putExtra("Imagen", article.getUrlToImage());
                intent.putExtra("Titulo", article.getTitle());
                intent.putExtra("Autor", article.getAuthor());
                intent.putExtra("Fecha", article.getPublishedAt());
                intent.putExtra("Descripcion", article.getDescription());
                intent.putExtra("Url", article.getUrl());
                intent.putExtra("Id", article.getId());
                articleLab.addArticle(article);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return articlesList == null? 0:articlesList.size();
    }
}
