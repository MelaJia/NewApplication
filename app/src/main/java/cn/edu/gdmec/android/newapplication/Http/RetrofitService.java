package cn.edu.gdmec.android.newapplication.Http;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Bean.NewsBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by apple on 18/5/29.
 */

public interface RetrofitService {

//    @GET("nc/article/{type}/{id}/{startPage}-20.html")
//    Call<NewsBean> getNews(@Path("type") String type,
//                           @Path("id") String id,
//                           @Path("startPage") int startPage);
//    @GET("v2/movie/{total}")
//    Call<MovieBean> getMovies(@Path("total") String total);
@GET("nc/article/{type}/{id}/{startPage}-20.html")
Observable<NewsBean> getNews(@Path("type") String type,
                             @Path("id") String id,
                             @Path("startPage") int startPage);
    @GET("v2/movie/{total}")
    Observable<MovieBean> getMovies(@Path("total") String total);

}
