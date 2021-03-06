package br.eng.jerodac.tweetfeeling.utils;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.luolc.emojirain.EmojiRainLayout;

import br.eng.jerodac.tweetfeeling.TweetFeelingApplication;
import br.eng.jerodac.tweetfeeling.bussiness.Feeling;
import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.controllers.MainController;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class AnimationSuite {

    public static void feelingAnimation(View view) {
        EmojiRainLayout emojiContainer = view.findViewById(R.id.group_emoji_container);
        PulsatorLayout pulsatorLayout = view.findViewById(R.id.pulsator);

        Feeling feeling = MainController.getInstance().getModel().getFeeling();
        emojiContainer.addEmoji(feeling.getResourceImage1());
        emojiContainer.addEmoji(feeling.getResourceImage2());
        emojiContainer.addEmoji(feeling.getResourceImage3());
        emojiContainer.startDropping();

        pulsatorLayout.setColor(ContextCompat.getColor(view.getContext(), feeling.getResourceColor()));
        pulsatorLayout.start();
    }

    public static void cleanFeelingAnimation(ViewGroup view) {
        if (view != null) {
            EmojiRainLayout emojiContainer = view.findViewById(R.id.group_emoji_container);
            PulsatorLayout pulsatorLayout = view.findViewById(R.id.pulsator);
            emojiContainer.stopDropping();
            pulsatorLayout.stop();
            emojiContainer.removeAllViews();
            pulsatorLayout.removeAllViews();
            view.removeAllViews();
        }
    }

    public static void pulseAnimation(final View view, final AnimationSuiteListener listener) {
        if (view.isEnabled()) {
            view.setEnabled(false);
            Animation pulse = AnimationUtils.loadAnimation(TweetFeelingApplication.context(), R.anim.pulse);
            view.startAnimation(pulse);
            pulse.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (listener != null) {
                        listener.onAnimationComplete();
                    }
                    view.setEnabled(true);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    public interface AnimationSuiteListener {
        void onAnimationComplete();
    }

}
