package cn.edu.gdmec.android.newapplication.Movie;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.Movie.Presenter.MoviePresenter;
import cn.edu.gdmec.android.newapplication.Movie.View.IMovieView;
import cn.edu.gdmec.android.newapplication.R;


public class FgMovieFragment extends Fragment implements IMovieView {

    private MoviePresenter presenter;
    private SwipeRefreshLayout srl_moves;
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
        srl_moves =view.findViewById(R.id.srl_news);
        srl_moves.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter=new MoviePresenter((IMovieView) this);
        srl_moves.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadMovie("in_theaters");
            }
        });


    }


    @Override
    public void showMovie(MovieBean movieBean) {
        tv_movie.setText(movieBean.getSubjects().get(0).getTitle()+
                ""+movieBean.getSubjects().get(0).getDirectors());
    }

    @Override
    public void hideDialog() {
        srl_moves.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_moves.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String error) {
        tv_movie.setText("加载错误！");

    }
}
