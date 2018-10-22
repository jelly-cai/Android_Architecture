package com.jelly.simplemvp.content;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.jelly.simplemvp.BaseActivity;
import com.jelly.simplemvp.R;
import com.jelly.simplemvp.content.bean.NewContent;
import com.jelly.simplemvp.util.ColorUtils;

public class ReadNewActivity extends BaseActivity implements ReadNewContract.View {

    public static final String TAG = "ReadNewActivity";

    private TextView tvTitle;
    private TextView tvTime;
    private TextView tvAuthor;
    private WebView wvContent;
    private ReadNewContract.Presenter presenter;
    private int newId = -1;

    private static final String NEWID_KEY = "newId";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_new);
        init();
    }

    @Override
    protected void init() {
        initToolBar();
        findViews();
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
        if(actionBar != null){
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

    private void findViews() {
        tvTitle = findViewById(R.id.tv_title);
        tvTime = findViewById(R.id.tv_time);
        wvContent = findViewById(R.id.wv_content);
        tvAuthor = findViewById(R.id.tv_author);
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
        String data = "<div background-color:" + ColorUtils.changeColor(ContextCompat.getColor(this, R.color.layout_bg)) + ">" + html + "</div>";
        wvContent.loadData(data, "text/html;charset=UTF-8", null);
    }

    public static void startActivity(Context context, int newId) {
        Intent intent = new Intent(context, ReadNewActivity.class);
        intent.putExtra(NEWID_KEY, newId);
        context.startActivity(intent);
    }

}

