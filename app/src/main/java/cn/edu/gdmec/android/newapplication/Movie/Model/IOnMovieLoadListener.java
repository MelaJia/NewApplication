package cn.edu.gdmec.android.newapplication.Movie.Model;

import android.graphics.Movie;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Bean.NewsBean;

/**
 * Created by apple on 18/5/29.
 */

public interface IOnMovieLoadListener {
    void success(MovieBean movieBean);
    void fail(String error);
}
