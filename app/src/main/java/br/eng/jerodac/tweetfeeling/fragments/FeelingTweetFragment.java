package br.eng.jerodac.tweetfeeling.fragments;

import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.widget.ImageView;

import com.luolc.emojirain.EmojiRainLayout;

import br.eng.jerodac.tweetfeeling.Feeling;
import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.models.Model;
import br.eng.jerodac.tweetfeeling.presenters.Presenter;
import br.eng.jerodac.tweetfeeling.utils.AnimationSuite;
import butterknife.BindView;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

/**
 * Created by cin_jcunha on 16/02/2018.
 */
public class FeelingTweetFragment extends BaseFragment implements Presenter {

    @BindView(R.id.group_emoji_container)
    protected EmojiRainLayout emojiCOntainer;

    @BindView(R.id.tv_tweet_feeling)
    protected AppCompatTextView tvFeelingTweet;

    @BindView(R.id.img_emoji)
    protected ImageView imgEmoji;

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
        getController().analytzText(this);
        AnimationSuite.feelingAnimation(emojiCOntainer, Feeling.HAPPY);
        imgEmoji.setImageResource(Feeling.HAPPY.getResourceImage1());
        tvFeelingTweet.setText(Feeling.HAPPY.getResourceString());
        pulsator.start();
    }

    @Override
    public void onSuccess(Model model) {

    }

    @Override
    public void onError() {

    }

    @Override
    protected void settings(View rootView) {

    }
}
