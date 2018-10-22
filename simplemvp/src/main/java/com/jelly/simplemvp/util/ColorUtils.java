package com.jelly.simplemvp.util;

import android.graphics.Color;

public class ColorUtils {

    public static String changeColor(int color){
        String result = "#";
        result += Integer.toHexString(Color.red(color));
        result += Integer.toHexString(Color.green(color));
        result += Integer.toHexString(Color.blue(color));
        return result;
    }

}
