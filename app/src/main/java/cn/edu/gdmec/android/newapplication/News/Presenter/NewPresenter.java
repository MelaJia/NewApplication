package cn.edu.gdmec.android.newapplication.News.Presenter;

import cn.edu.gdmec.android.newapplication.Bean.NewsBean;
import cn.edu.gdmec.android.newapplication.Http.Api;
import cn.edu.gdmec.android.newapplication.News.Model.INewsModel;
import cn.edu.gdmec.android.newapplication.News.Model.IOnLoadListener;
import cn.edu.gdmec.android.newapplication.News.Model.NewsModel;
import cn.edu.gdmec.android.newapplication.News.View.FgNewsFragment;
import cn.edu.gdmec.android.newapplication.News.View.INewsView;

/**
 * Created by apple on 18/5/29.
 */

public class NewPresenter implements INewsPresenter,IOnLoadListener {
    private INewsModel iNewsModel;
    private INewsView iNewsView;

    public NewPresenter(INewsView iNewsView) {
        this.iNewsView = iNewsView;
        this.iNewsModel=new NewsModel();
    }

    @Override
    public void loadNews(int type, int startPage) {
        iNewsView.showDialog();
        switch (type){
            case FgNewsFragment.NEWS_TYPE_TOP:
                iNewsModel.loadNews("headline",startPage, Api.HEADLINE_ID,this);
                break;
            case FgNewsFragment.NEWS_TYPE_NBA:
                iNewsModel.loadNews("list",startPage, Api.NBA_ID,this);
                break;
            case FgNewsFragment.NEWS_TYPE_JOKES:
                iNewsModel.loadNews("list",startPage, Api.JOKE_ID,this);
                break;
        }

    }

    @Override
    public void success(NewsBean newsBean) {
        iNewsView.hideDialog();
        if (newsBean!=null){
            iNewsView.showNews(newsBean);
        }

    }

    @Override
    public void fail(String error) {
        iNewsView.hideDialog();
        iNewsView.showErrorMsg(error);

    }
}
