package com.jelly.architecture;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {

    private Toast toast;
    /**
     * 界面的初始化入口
     */
    protected abstract void init();

    public void showToast(String message){
        if(toast == null){
            toast = Toast.makeText(getApplicationContext(),message,Toast.LENGTH_SHORT);
            toast.show();
        }else{
            toast.setText(message);
            toast.show();
        }
    }

}
