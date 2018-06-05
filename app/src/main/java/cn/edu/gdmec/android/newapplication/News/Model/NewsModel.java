package cn.edu.gdmec.android.newapplication.News.Model;

import cn.edu.gdmec.android.newapplication.Bean.NewsBean;
import cn.edu.gdmec.android.newapplication.Http.Api;
import cn.edu.gdmec.android.newapplication.Http.RetrofitHelper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by apple on 18/5/29.
 */

public class NewsModel implements INewsModel{
    @Override
    public void loadNews(String hostType, int startPage, String id, final IOnLoadListener iOnLoadListener) {
        RetrofitHelper retrofitHelper=new RetrofitHelper(Api.NEWS_HOST);
//        retrofitHelper.getNews(hostType,id,startPage).enqueue(new Callback<NewsBean>() {
//            @Override
//            public void onResponse(Call<NewsBean> call, Response<NewsBean> response) {
//                if (response.isSuccessful()){
//                    iOnLoadListener.success(response.body());
//                }else {
//                    iOnLoadListener.fail("");
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsBean> call, Throwable t) {
//                iOnLoadListener.fail(t.toString());
//
//            }
//        });
        retrofitHelper.getNew(hostType,id,startPage)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<NewsBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        iOnLoadListener.fail(e.getMessage());

                    }

                    @Override
                    public void onNext(NewsBean newsBean) {
                        iOnLoadListener.success(newsBean);

                    }
                });
    }
}
