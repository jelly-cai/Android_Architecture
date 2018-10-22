package com.jelly.simplemvp.main;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.jelly.simplemvp.BaseActivity;
import com.jelly.simplemvp.R;
import com.jelly.simplemvp.common.listener.RVOnItemClickListener;
import com.jelly.simplemvp.content.ReadNewActivity;
import com.jelly.simplemvp.main.bean.NewsList;

public class MvpMainActivity extends BaseActivity implements MainContract.View {

    private RecyclerView rvContent;
    private SwipeRefreshLayout swipeContent;

    private MainContract.Presenter mainPresenter;

    private NewsAdapter adapter;

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

    /**
     * 设置刷新监听器
     */
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

    private void setAdapter(final NewsList newsList) {
        adapter = new NewsAdapter(this, newsList.getData().getNewList());
        rvContent.setLayoutManager(new LinearLayoutManager(this));
        rvContent.setAdapter(adapter);
        adapter.setItemClickListener(new RVOnItemClickListener() {
            @Override
            public void itemClick(View item, int position) {
                ReadNewActivity.startActivity(MvpMainActivity.this,newsList.getData().getNewList().get(position).getNewID());
            }
        });
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
