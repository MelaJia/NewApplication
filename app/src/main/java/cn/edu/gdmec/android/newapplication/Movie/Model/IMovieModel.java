package cn.edu.gdmec.android.newapplication.Movie.Model;

import cn.edu.gdmec.android.newapplication.News.Model.IOnLoadListener;

/**
 * Created by apple on 18/5/29.
 */

public interface IMovieModel {
    void loadMovie(String total,
                  IOnMovieLoadListener iOnMovieLoadListener);
}
