package br.eng.jerodac.tweetfeeling.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.twitter.sdk.android.core.models.Tweet;
import com.twitter.sdk.android.tweetui.Timeline;
import com.twitter.sdk.android.tweetui.TweetTimelineListAdapter;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class CustomTweetTimelineListAdapter extends TweetTimelineListAdapter {

    private OnListItemClickListener mOnListItemClickListener;

    public CustomTweetTimelineListAdapter(Context context, Timeline<Tweet> timeline) {
        super(context, timeline);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        //disable subviews
        if (view instanceof ViewGroup) {
            disableViewAndSubViews((ViewGroup) view);
        }

        //enable root view and attach custom listener
        view.setEnabled(true);
        view.setOnClickListener(v -> {
            String tweetId = "click tweetId:" + getItemId(position);
            if (mOnListItemClickListener != null) {
                mOnListItemClickListener.onClickItem(position, getItem(position), view);
            }
        });
        return view;
    }

    public void setOnListItemClickListener(OnListItemClickListener onListItemClickListener) {
        mOnListItemClickListener = onListItemClickListener;
    }

    private void disableViewAndSubViews(ViewGroup layout) {
        layout.setEnabled(false);
        for (int i = 0; i < layout.getChildCount(); i++) {
            View child = layout.getChildAt(i);
            if (child instanceof ViewGroup) {
                disableViewAndSubViews((ViewGroup) child);
            } else {
                child.setEnabled(false);
                child.setClickable(false);
                child.setLongClickable(false);
            }
        }
    }

    public interface OnListItemClickListener {
        void onClickItem(int position, Tweet tweet, View view);
    }

}