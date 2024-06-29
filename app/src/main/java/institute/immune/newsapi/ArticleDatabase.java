package institute.immune.newsapi;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Articles.class},version = 1, exportSchema = false)
public abstract class ArticleDatabase extends RoomDatabase {
    public abstract ArticleDao getArticleDao();
}
