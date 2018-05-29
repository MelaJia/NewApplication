package cn.edu.gdmec.android.newapplication.Movie;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import java.util.TimerTask;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Movie.Presenter.MoviePresenter;
import cn.edu.gdmec.android.newapplication.Movie.View.IMovieView;
import cn.edu.gdmec.android.newapplication.News.Presenter.NewPresenter;
import cn.edu.gdmec.android.newapplication.R;


public class FgMovieFragment extends Fragment implements IMovieView {

    private MoviePresenter presenter;
    private SwipeRefreshLayout srl_news;
    private String total;
    private TextView tv_movie;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fg_movie,container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_movie=view.findViewById(R.id.tv_movie);
        srl_news=view.findViewById(R.id.srl_news);
        srl_news.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter=new MoviePresenter((IMovieView) this);
        srl_news.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadMovie("");
            }
        });


    }


    @Override
    public void showMovie(final MovieBean movieBean) {
        getActivity().runOnUiThread(new TimerTask() {
            @Override
            public void run() {
                tv_movie.setText(movieBean.getTotal());
            }
        });
    }

    @Override
    public void hideDialog() {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void showErrorMsg(String error) {

    }
}
