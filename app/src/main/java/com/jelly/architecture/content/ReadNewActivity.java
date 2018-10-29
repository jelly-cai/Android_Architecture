package com.jelly.architecture.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.jelly.architecture.BaseActivity;
import com.jelly.architecture.R;
import com.jelly.architecture.content.bean.NewContent;
import com.jelly.architecture.util.ColorUtils;
import com.jelly.architecture.util.ToastUtils;

import javax.inject.Inject;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadNewActivity extends BaseActivity implements ReadNewContract.View {

    public static final String TAG = "ReadNewActivity";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_author)
    TextView tvAuthor;
    @BindView(R.id.wv_content)
    WebView wvContent;

    @BindString(R.string.new_content_html_format)
    String htmlFormat;
    @BindColor(R.color.layout_bg)
    int layoutBg;

    @Inject
    ReadNewContract.Presenter presenter;

    public static final String NEWID_KEY = "newId";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_new);
        ButterKnife.bind(this);
        init();
    }

    @Override
    protected void init() {
        initToolBar();
        presenter.takeView(this);
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }

    @Override
    public void showContent(NewContent content) {
        tvTitle.setText(content.getData().getNewTitle());
        tvTime.setText(content.getData().getPublishTime());
        tvAuthor.setText(content.getData().getSourceName());
        setWebView(content.getData().getNewContent());
    }

    private void setWebView(String html) {
        wvContent.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        wvContent.getSettings().setSupportZoom(false);
        String data = String.format(htmlFormat,ColorUtils.changeColor(layoutBg),html);
        wvContent.loadData(data, "text/html;charset=UTF-8", null);
    }

    public static void startActivity(Context context, int newId) {
        Intent intent = new Intent(context, ReadNewActivity.class);
        intent.putExtra(NEWID_KEY, newId);
        context.startActivity(intent);
    }

}

