package cn.edu.gdmec.android.newapplication.Movie.View;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Bean.NewsBean;

/**
 * Created by apple on 18/5/29.
 */

public interface IMovieView {
    void showMovie(MovieBean movieBean);
    void hideDialog();
    void showDialog();
    void showErrorMsg(String error);

}
