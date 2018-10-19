package com.jelly.simplemvp.main;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jelly.simplemvp.BaseActivity;
import com.jelly.simplemvp.R;
import com.jelly.simplemvp.main.bean.NewsList;

public class MvpMainActivity extends BaseActivity implements MainContract.View{

    RecyclerView rvContent;
    MainContract.Presenter mainPresenter;

    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_main);
        init();
    }

    @Override
    protected void init() {
        initToolBar();
        findViews();
        setPresenter(new MainPresenter(new MainModel(),this));
        mainPresenter.start();
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar(){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * 获取view
     */
    private void findViews(){
        rvContent = findViewById(R.id.rv_content);
    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }

    @Override
    public void showNews(NewsList newsList) {
        adapter = new NewsAdapter(this,newsList.getData().getNewList());
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter);
    }
}
