package institute.immune.newsapi;

import android.content.Context;

import androidx.room.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GuardadasService {
    private static GuardadasService GuardadasService;

    private GuardadasDao mGuardadasDao;

    public GuardadasService(Context context) {
        Context appContext = context.getApplicationContext();
        GuardadasDatabase database = Room.databaseBuilder(appContext,GuardadasDatabase.class,"Guardadas").allowMainThreadQueries().build();
        mGuardadasDao = database.getGuardadasDao();
    }
    public static GuardadasService get(Context context){
        if(GuardadasService == null){
            GuardadasService = new GuardadasService(context);
        }
        return GuardadasService;
    }

    public List<Guardadas> getGuardadas(){
        return mGuardadasDao.getGuardadas();
    }
    public Guardadas getGuardada(String id){return mGuardadasDao.getGuardada(id);}

    public void addGuardadas(Guardadas Guardadas){
        mGuardadasDao.addGuardadas(Guardadas);
    }

    public void deleteGuardadas(Guardadas Guardadas){
        mGuardadasDao.deleteGuardadas(Guardadas);
    }

    public void updateGuardadas(Guardadas Guardadas){
        mGuardadasDao.updateGuardadas(Guardadas);
    }
}
