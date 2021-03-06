package br.eng.jerodac.tweetfeeling;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;

import br.eng.jerodac.tweetfeeling.language.NaturalLanguageInitializer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class TweetFeelingApplication extends Application {

    private static Context mContext;

    public static Context context() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());

        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build());

        Twitter.initialize(this);

        final HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        final OkHttpClient customClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor).build();

        final TwitterSession activeSession = TwitterCore.getInstance()
                .getSessionManager().getActiveSession();

        final TwitterApiClient customApiClient;
        if (activeSession != null) {
            customApiClient = new TwitterApiClient(activeSession, customClient);
            TwitterCore.getInstance().addApiClient(activeSession, customApiClient);
        } else {
            customApiClient = new TwitterApiClient(customClient);
            TwitterCore.getInstance().addGuestApiClient(customApiClient);
        }

        NaturalLanguageInitializer.init();
    }
}
