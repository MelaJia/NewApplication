package cn.edu.gdmec.android.newapplication.Movie;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import cn.edu.gdmec.android.newapplication.Bean.MovieBean;
import cn.edu.gdmec.android.newapplication.ItemMovieOnAdapter;
import cn.edu.gdmec.android.newapplication.Movie.Presenter.MoviePresenter;
import cn.edu.gdmec.android.newapplication.Movie.View.IMovieView;
import cn.edu.gdmec.android.newapplication.R;


public class FgMovieFragment extends Fragment implements IMovieView {

    private MoviePresenter presenter;
    private RecyclerView rv_movie_on;
    private SwipeRefreshLayout srl_movie;
    private ItemMovieOnAdapter movieOnAdapter;
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
//        presenter=new MoviePresenter((IMovieView) this);
//     //   tv_movie=view.findViewById(R.id.tv_movie);
//        srl_moves =view.findViewById(R.id.srl_news);
//        srl_moves.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
//        rv_movie_on = view.findViewById(R.id.rv_movie_on);
//        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
//
//
//        presenter.loadMovie("in_theaters");
        presenter = new MoviePresenter(this);
        srl_movie = view.findViewById(R.id.srl_movie);
        rv_movie_on = view.findViewById(R.id.rv_movie_on);
        movieOnAdapter = new ItemMovieOnAdapter(getActivity());
        srl_movie.setColorSchemeColors(Color.parseColor("#ffce3d3a"));
        presenter.loadMovie("in_theaters");


        srl_movie.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.loadMovie("in_theaters");
            }
        });


    }


    @Override
    public void showMovie(MovieBean movieBean) {
//        tv_movie.setText(movieBean.getSubjects().get(0).getTitle()+
//                ""+movieBean.getSubjects().get(0).getDirectors());
        movieOnAdapter.setData(movieBean.getSubjects());
        rv_movie_on.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_movie_on.setAdapter(movieOnAdapter);
    }

    @Override
    public void hideDialog() {
        srl_movie.setRefreshing(false);
    }

    @Override
    public void showDialog() {
        srl_movie.setRefreshing(true);
    }

    @Override
    public void showErrorMsg(String error) {
        //tv_movie.setText("加载错误！");
        Toast.makeText(getContext(), "加载出错:"+error, Toast.LENGTH_SHORT).show();

    }
}
