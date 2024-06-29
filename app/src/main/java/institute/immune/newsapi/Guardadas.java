package institute.immune.newsapi;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Guardadas")
public class Guardadas {
    @PrimaryKey
    @NonNull
    private String id;
    @ColumnInfo(name = "ArticuloTitulo")
    private String title;
    @ColumnInfo(name = "ArticuloAutor")
    private String author;
    @ColumnInfo(name = "ArticuloDescripcion")
    private String description;
    @ColumnInfo(name = "ArticuloURL")
    private String url;
    @ColumnInfo(name = "ArticuloImagen")
    private String urlToImage;
    @ColumnInfo(name = "ArticuloFecha")
    private String publishedAt;
    @ColumnInfo(name = "ArticuloContenido")
    private String content;

    public Guardadas(String author, String title, String description, String url, String urlToImage, String publishedAt, String content,String id) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.content = content;
        this.id=id;
    }

    public String getId() {return id;}

    public void setId( String mId) {this.id = mId;}

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

