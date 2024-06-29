package institute.immune.newsapi;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Guardadas.class},version = 1, exportSchema = false)
public abstract class GuardadasDatabase extends RoomDatabase {
    public abstract GuardadasDao getGuardadasDao();
}
