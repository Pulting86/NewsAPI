package institute.immune.newsapi;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class SavedDetails extends AppCompatActivity {

    private String fecha_string, id;
    private TextView txt_titulo, txt_autor, txt_fecha, txt_descripcion, txt_urlcompleta;
    private ImageView imagen;
    private Button btn_volver,btn_guardar;
    private ArticleService articleLab;

    private GuardadasService guardadasService;

    @SuppressLint({"SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_saved_details);
        Intent intent = getIntent();
        txt_titulo = findViewById(R.id.txt_titulo);
        txt_autor = findViewById(R.id.txt_autor);
        txt_fecha = findViewById(R.id.txt_fecha);
        txt_descripcion = findViewById(R.id.txt_descripcion);
        txt_urlcompleta = findViewById(R.id.txt_urlcompleta);
        imagen = findViewById(R.id.imagen);
        btn_volver = findViewById(R.id.btn_volver);
        btn_guardar = findViewById(R.id.btn_guardar);
        articleLab = ArticleService.get(this);
        fecha_string = intent.getStringExtra("Fecha");
        String[] fecha = fecha_string.split("T");
        String fecha_definitiva = fecha[0];
        id = intent.getStringExtra("Id");

        txt_titulo.setText(intent.getStringExtra("Titulo"));
        txt_autor.setText("By " + intent.getStringExtra("Autor"));
        txt_fecha.setText(fecha_definitiva);
        txt_descripcion.setText(intent.getStringExtra("Descripcion"));
        txt_urlcompleta.setText("Información completa: " + intent.getStringExtra("Url"));
        if (intent.getStringExtra("Imagen") == null){
            Picasso.get().load("https://www.webempresa.com/foro/wp-content/uploads/wpforo/attachments/3200/318277=80538-Sin_imagen_disponible.jpg").into(imagen);
        } else {
            Picasso.get().load(intent.getStringExtra("Imagen")).into(imagen);
        }
        guardadasService = GuardadasService.get(this);


        btn_volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), GuardadasAdapter.class);
                startActivity(intent1);
            }
        });

        btn_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardadasService.deleteGuardadas(guardadasService.getGuardada(id));
                Toast.makeText(getBaseContext(), "Articulo eliminado correctamente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}