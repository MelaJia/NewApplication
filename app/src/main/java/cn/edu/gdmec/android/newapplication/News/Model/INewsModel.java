package cn.edu.gdmec.android.newapplication.News.Model;

/**
 * Created by apple on 18/5/29.
 */

public interface INewsModel {
    void loadNews(String hostType,
                  int startPage,
                  String id,
                  IOnLoadListener iOnLoadListener);
}
