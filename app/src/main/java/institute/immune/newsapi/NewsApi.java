package institute.immune.newsapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsApi {
    @GET("v2/everything")
    Call<List<New>> getNews();

    @GET("v2/everything")
    Call<New> getNew(@Query(("q")) String q,@Query(("apiKey")) String API_KEY);
}
