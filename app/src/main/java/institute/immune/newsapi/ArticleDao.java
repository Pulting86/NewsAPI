package institute.immune.newsapi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ArticleDao {
    @Query("SELECT * FROM Noticias WHERE id LIKE :id")
    Articles getArticle(String id);

    @Insert
    void addArticle(Articles articles);

    @Delete
    void deleteArticle(Articles articles);

    @Update
    void updateArticle(Articles articles);
}
