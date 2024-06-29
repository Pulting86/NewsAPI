package institute.immune.newsapi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface GuardadasDao {
    @Query("SELECT * FROM Guardadas")
    List<Guardadas> getGuardadas();

    @Query("SELECT * FROM Guardadas WHERE id LIKE :id")
    Guardadas getGuardada(String id);
    @Insert
    void addGuardadas(Guardadas guardadas);

    @Delete
    void deleteGuardadas(Guardadas guardadas);

    @Update
    void updateGuardadas(Guardadas guardadas);
}
