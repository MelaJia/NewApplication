package cn.edu.gdmec.android.newapplication.Movie.Model;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Bean.NewsBean;
import cn.edu.gdmec.android.newapplication.Http.Api;
import cn.edu.gdmec.android.newapplication.Http.RetrofitHelper;
import cn.edu.gdmec.android.newapplication.News.Model.INewsModel;
import cn.edu.gdmec.android.newapplication.News.Model.IOnLoadListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/29.
 */

public class MovieModel implements IMovieModel{


    @Override
    public void loadMovie(String total, final IOnMovieLoadListener iOnMovieLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.MOVIE_HOST);
//        retrofitHelper.getMovies(total).enqueue(new Callback<MovieBean>() {
//            @Override
//            public void onResponse(Call<MovieBean> call, Response<MovieBean> response) {
//                if (response.isSuccessful()){
//                    iOnMovieLoadListener.success(response.body());
//                }else {
//                    iOnMovieLoadListener.fail("");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MovieBean> call, Throwable t) {
//                iOnMovieLoadListener.fail(t.toString());
//
//            }
//        });
        retrofitHelper.getMovies(total)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<MovieBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnMovieLoadListener.fail(e.getMessage());

                    }

                    @Override
                    public void onNext(MovieBean movieBean) {
                        iOnMovieLoadListener.success(movieBean);

                    }
                });

    }
}
