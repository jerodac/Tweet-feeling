package br.eng.jerodac.tweetfeeling.utils;

import android.util.Log;

import br.eng.jerodac.tweetfeeling.BuildConfig;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class AppLog {

    public final static String TAG = "TweetFeeling";
    //Ativa logs
    static final boolean isDebug = BuildConfig.DEBUG;

    public static void e(String tag, Throwable e) {
        e(tag, "Error", e);
    }

    public static void e(String tag, String message) {
        if (isDebug) {
            Log.e(tag, message);
        }
    }

    public static void e(String tag, String message, Throwable e) {
        if (isDebug) {
            Log.e(tag, message, e);
        }
    }

    public static void i(String tag, String message) {
        if (isDebug) {
            Log.i(tag, message);
        }
    }

    public static void v(String tag, String message) {
        if (isDebug) {
            Log.v(tag, message);
        }
    }

    public static boolean isDebug() {
        return isDebug;
    }
}
