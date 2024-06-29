package institute.immune.newsapi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GuardadasAdapter extends RecyclerView.Adapter<GuardadasViewHolder> {

    private final Context context;
    private final ArrayList<Guardadas> guardadasList;
    private GuardadasService guardadasLab;

    public GuardadasAdapter(Context context, ArrayList<Guardadas> guardadasList) {
        this.context = context;
        this.guardadasList = guardadasList;
        guardadasLab = GuardadasService.get(this.context);
    }

    @NonNull
    @Override
    public GuardadasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.new_view, parent, false);
        return new GuardadasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuardadasViewHolder holder, int position) {
        Guardadas article = guardadasList.get(position);
        holder.setTxt_author("by " + article.getAuthor());
        holder.setTxt_title(article.getTitle());
        holder.setImage(article.getUrlToImage());
        holder.setTxt_publishedAt(article.getPublishedAt());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SavedDetails.class);
                intent.putExtra("Imagen", article.getUrlToImage());
                intent.putExtra("Titulo", article.getTitle());
                intent.putExtra("Autor", article.getAuthor());
                intent.putExtra("Fecha", article.getPublishedAt());
                intent.putExtra("Descripcion", article.getDescription());
                intent.putExtra("Url", article.getUrl());
                intent.putExtra("Id", article.getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return guardadasList == null? 0:guardadasList.size();
    }
}
