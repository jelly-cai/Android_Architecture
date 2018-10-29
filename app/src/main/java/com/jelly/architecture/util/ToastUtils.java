package com.jelly.architecture.util;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    Toast toast;

    public ToastUtils(Context context){
        toast = Toast.makeText(context,null,Toast.LENGTH_SHORT);
    }

    public void showMessage(String message){
        toast.setText(message);
        toast.show();
    }

}
