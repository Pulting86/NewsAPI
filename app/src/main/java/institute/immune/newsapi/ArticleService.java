package institute.immune.newsapi;

import android.content.Context;

import androidx.room.Room;

public class ArticleService {
    private static ArticleService sArticleService;

    private ArticleDao mArticleDao;

    public ArticleService(Context context) {
        Context appContext = context.getApplicationContext();
        ArticleDatabase database = Room.databaseBuilder(appContext,ArticleDatabase.class,"Article").allowMainThreadQueries().build();
        mArticleDao = database.getArticleDao();
    }
    public static ArticleService get(Context context){
        if(sArticleService == null){
            sArticleService = new ArticleService(context);
        }
        return sArticleService;
    }

    public Articles getArticle(String id){
        return mArticleDao.getArticle(id);
    }

    public void addArticle(Articles Article){
        mArticleDao.addArticle(Article);
    }

    public void deleteArticle(Articles Article){
        mArticleDao.deleteArticle(Article);
    }

    public void updateArticle(Articles Article){
        mArticleDao.updateArticle(Article);
    }
}
