package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.SearchTimeline;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.adapter.CustomTweetTimelineListAdapter;
import br.eng.jerodac.tweetfeeling.utils.AnimationSuite;

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

    private CustomTweetTimelineListAdapter adapter;

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

        adapter = new CustomTweetTimelineListAdapter(getContext(), timeline);
        setListAdapter(adapter);
        adapter.setOnListItemClickListener(onListItemClickListener);

    }

    private CustomTweetTimelineListAdapter.OnListItemClickListener onListItemClickListener = (int position, Tweet tweet, View view) -> {
        AnimationSuite.pulseAnimation(view, () -> {
            getController().setTweetSelected(tweet);
            getFlowManager().replace(CheckFeelingTweetFragment.newInstance(), true);
        });
    };


    @Override
    protected void settings(View rootView) {
        getMainActivity().getToolbar().setTitle(getController().getModel().getDisplayTweetTag());
    }
}
