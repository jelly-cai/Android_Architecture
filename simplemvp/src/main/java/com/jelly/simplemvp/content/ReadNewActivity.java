package com.jelly.simplemvp.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.jelly.simplemvp.BaseActivity;
import com.jelly.simplemvp.R;
import com.jelly.simplemvp.R2;
import com.jelly.simplemvp.content.bean.NewContent;
import com.jelly.simplemvp.util.ColorUtils;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ReadNewActivity extends BaseActivity implements ReadNewContract.View {

    public static final String TAG = "ReadNewActivity";
    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.tv_title)
    TextView tvTitle;
    @BindView(R2.id.tv_time)
    TextView tvTime;
    @BindView(R2.id.tv_author)
    TextView tvAuthor;
    @BindView(R2.id.wv_content)
    WebView wvContent;

    @BindString(R2.string.new_content_html_format)
    String htmlFormat;
    @BindColor(R2.color.layout_bg)
    int layoutBg;

    private ReadNewContract.Presenter presenter;
    private int newId = -1;

    private static final String NEWID_KEY = "newId";

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
        getIntentData();
        setPresenter(new ReadNewPresenter(new ReadNewModel(), this, newId));
        presenter.start();
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


    private void getIntentData() {
        Intent intent = getIntent();
        if (intent == null) {
            throw new NullPointerException("Intent为空");
        }
        newId = getIntent().getIntExtra(NEWID_KEY, -1);
        if (newId == -1) {
            Toast.makeText(this, "newId不能为空", Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    public void setPresenter(ReadNewContract.Presenter presenter) {
        this.presenter = presenter;
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

