package br.eng.jerodac.tweetfeeling.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
public class AppUtil {
    public static void hideKeyboard(View view) {
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static void setStatusBarColor(AppCompatActivity activity, int resourceColor) {
        Window window = activity.getWindow();
        window.setStatusBarColor(ContextCompat.getColor(activity, resourceColor));
    }

}
