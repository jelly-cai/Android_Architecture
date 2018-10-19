package com.jelly.simplemvp.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.jelly.simplemvp.BaseActivity;
import com.jelly.simplemvp.R;
import com.jelly.simplemvp.main.bean.NewsList;

public class MvpMainActivity extends BaseActivity implements MainContract.View {

    RecyclerView rvContent;
    SwipeRefreshLayout swipeContent;

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
        initSwipe();
        setPresenter(new MainPresenter(new MainModel(), this));
        mainPresenter.start();
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    /**
     * 获取view
     */
    private void findViews() {
        rvContent = findViewById(R.id.rv_content);
        swipeContent = findViewById(R.id.swipe_content);
    }

    private void initSwipe() {
        swipeContent.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mainPresenter.refreshNews();
            }
        });
    }

    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        mainPresenter = presenter;
    }

    private void setAdapter(NewsList newsList) {
        adapter = new NewsAdapter(this, newsList.getData().getNewList());
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter);
    }

    @Override
    public void showNews(NewsList newsList) {
        setAdapter(newsList);
    }

    @Override
    public void refreshNews(NewsList newsList) {
        setAdapter(newsList);
        swipeContent.setRefreshing(false);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int i = item.getItemId();
        if (i == R.id.refresh) {
            swipeContent.setRefreshing(true);
            mainPresenter.refreshNews();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mvp_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
