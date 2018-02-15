package br.eng.jerodac.tweetfeeling.fragments;

import android.util.Log;
import android.view.View;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.TwitterCoreMainActivity;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class ListTweetsFragment extends BaseFragment {

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.list_tweets_fragment;
    }

    @Override
    protected void initComponents(View rootView) {
        final SearchTimeline timeline = new SearchTimeline.Builder().query("#twitter").build();
        final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(getActivity())
                .setTimeline(timeline)
                .setViewStyle(R.style.tw__TweetLightWithActionsStyle)
                .setOnActionCallback(actionCallback)
                .build();

        setListAdapter(adapter);
    }

    // launch the app login activity when a guest user tries to favorite a Tweet
    final Callback<Tweet> actionCallback = new Callback<Tweet>() {
        @Override
        public void success(Result<Tweet> result) {
            Log.v("TAG", "Callback: success");
        }

        @Override
        public void failure(TwitterException exception) {
            Log.v("TAG", "Callback: Erro");
            if (exception instanceof TwitterAuthException) {
                startActivity(TwitterCoreMainActivity.newIntent(getActivity()));
            }
        }
    };

    @Override
    protected void settings(View rootView) {

    }
}
