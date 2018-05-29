package cn.edu.gdmec.android.newapplication.Movie.Presenter;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Bean.NewsBean;
import cn.edu.gdmec.android.newapplication.Http.Api;
import cn.edu.gdmec.android.newapplication.Movie.Model.IMovieModel;
import cn.edu.gdmec.android.newapplication.Movie.Model.IOnMovieLoadListener;
import cn.edu.gdmec.android.newapplication.Movie.Model.MovieModel;
import cn.edu.gdmec.android.newapplication.Movie.View.IMovieView;
import cn.edu.gdmec.android.newapplication.News.Model.INewsModel;
import cn.edu.gdmec.android.newapplication.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.newapplication.News.Model.NewsModel;
import cn.edu.gdmec.android.newapplication.News.Presenter.INewsPresenter;
import cn.edu.gdmec.android.newapplication.News.View.FgNewsFragment;
import cn.edu.gdmec.android.newapplication.News.View.INewsView;

/**
 * Created by apple on 18/5/29.
 */

public class MoviePresenter implements IMoviePresenter,IOnMovieLoadListener {
    private IMovieModel iMovieModel;
    private IMovieView iMovieView;

    public MoviePresenter(IMovieView iMovieView) {
        this.iMovieView = iMovieView;
        this.iMovieModel=new MovieModel();
    }

    @Override
    public void loadMovie(String total) {
        iMovieView.showDialog();

        iMovieModel.loadMovie(total,this);

        }



    @Override
    public void success(MovieBean movieBean) {
    iMovieView.hideDialog();
    if (movieBean!=null){
        iMovieView.showMovie(movieBean);

    }

}

    @Override
    public void fail(String error) {
        iMovieView.hideDialog();
        iMovieView.showErrorMsg(error);

    }
}
