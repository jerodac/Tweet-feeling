package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;
import android.widget.Toast;

import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.SearchTimeline;
import com.twitter.sdk.android.tweetui.TimelineResult;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.adapter.CustomTweetTimelineListAdapter;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class ListTweetsFragment extends BaseListFragment {

    public static ListTweetsFragment newInstance() {
        return new ListTweetsFragment();
    }

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
        final SearchTimeline timeline = new SearchTimeline
                .Builder()
                .query(getModel().getTweetTag())
                .build();

        CustomTweetTimelineListAdapter adapter = new CustomTweetTimelineListAdapter(getContext(), timeline);

        setListAdapter(adapter);
        adapter.setOnListItemClickListener(onListItemClickListener);
        adapter.refresh(updateCallback);
    }

    final Callback<TimelineResult<Tweet>> updateCallback = new Callback<TimelineResult<Tweet>>() {
        @Override
        public void success(Result<TimelineResult<Tweet>> result) {

        }

        @Override
        public void failure(TwitterException exception) {
            //validate();
        }
    };

    CustomTweetTimelineListAdapter.OnListItemClickListener onListItemClickListener = (int position, Tweet tweet, View view) -> {
        getFlowManager().replace(new FeelingTweetFragment(), false);
    };

    private void validate() {
        if (getListAdapter().getCount() > 0) {
            return;
        }

        if (getListAdapter().getCount() == 0) {
            //todo show empty item
        } else {
            //todo show snakbar
        }
    }

    @Override
    protected void settings(View rootView) {
        getActivity().setTitle(getController().getModel().getDisplayTweetTag());
    }
}
