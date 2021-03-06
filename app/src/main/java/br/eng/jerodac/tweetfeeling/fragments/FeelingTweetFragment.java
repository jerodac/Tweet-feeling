package br.eng.jerodac.tweetfeeling.fragments;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luolc.emojirain.EmojiRainLayout;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.bussiness.Feeling;
import br.eng.jerodac.tweetfeeling.utils.AnimationSuite;
import br.eng.jerodac.tweetfeeling.utils.AppUtil;
import butterknife.BindView;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class FeelingTweetFragment extends BaseFragment {

    public static FeelingTweetFragment newInstance() {
        return new FeelingTweetFragment();
    }

    @BindView(R.id.group_emoji_container)
    protected EmojiRainLayout emojiContainer;

    @BindView(R.id.tv_tweet_feeling)
    protected AppCompatTextView tvFeelingTweet;

    @BindView(R.id.img_emoji)
    protected ImageView imgEmoji;

    @BindView(R.id.tv_score)
    protected AppCompatTextView tvScore;

    @BindView(R.id.tv_magnitude)
    protected AppCompatTextView tvMagnitude;

    @BindView(R.id.pulsator)
    protected PulsatorLayout pulsator;

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.feeling_tweet_layout;
    }

    @Override
    protected void initComponents(View rootView) {
        Feeling feeling = getModel().getFeeling();
        AnimationSuite.feelingAnimation(rootView);
        imgEmoji.setImageResource(feeling.getResourceImage1());
        tvFeelingTweet.setText(feeling.getResourceString());
        tvFeelingTweet.setTextColor(ContextCompat.getColor(getContext(), feeling.getResourceColor()));
        tvScore.setText(String.valueOf(getModel().getScoreFeeling()));
        tvMagnitude.setText(String.valueOf(getModel().getMagnitudeFeeling()));
    }

    @Override
    protected void settings(View rootView) {
        getMainActivity().getToolbar().setTitle(getModel().getFeeling().getResourceString());
        getMainActivity().getToolbar().setBackgroundColor(ContextCompat.getColor(getContext(), getModel().getFeeling().getResourceColor()));
        AppUtil.setStatusBarColor(getMainActivity(), getModel().getFeeling().getmResourceColorDark());
    }

    @Override
    public void onDestroyView() {
        AnimationSuite.cleanFeelingAnimation((ViewGroup) getView());
        getMainActivity().getToolbar().setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimary));
        AppUtil.setStatusBarColor(getMainActivity(), R.color.colorPrimaryDark);
        super.onDestroyView();
    }
}
