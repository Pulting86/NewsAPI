package institute.immune.newsapi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

public class NewViewHolder extends RecyclerView.ViewHolder {

    TextView txt_titulo_carta, txt_autor_carta, txt_fecha_carta;

    ImageView imagenicono;
    public NewViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_titulo_carta = itemView.findViewById(R.id.txt_titulo_carta);
        txt_autor_carta = itemView.findViewById(R.id.txt_autor_carta);
        txt_fecha_carta = itemView.findViewById(R.id.txt_fecha_carta);
        imagenicono = itemView.findViewById(R.id.imagenicono);

    }

    public void setTxt_author(String txt_author) {
        this.txt_autor_carta.setText(txt_author);
    }

    public void setTxt_title(String txt_title) {
        this.txt_titulo_carta.setText(txt_title);
    }

    public void setImage(String url) {
        if (!url.isEmpty()){
            Picasso.get().load(url).into(imagenicono);
        }else {
            Picasso.get().load("https://www.webempresa.com/foro/wp-content/uploads/wpforo/attachments/3200/318277=80538-Sin_imagen_disponible.jpg").into(imagenicono);
        }
    }

    public void setTxt_publishedAt(String txt_publishedAt) {
        this.txt_fecha_carta.setText(txt_publishedAt);
    }
}
