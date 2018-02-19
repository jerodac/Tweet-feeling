package br.eng.jerodac.tweetfeeling.utils;

import android.view.View;

import com.luolc.emojirain.EmojiRainLayout;

import br.eng.jerodac.tweetfeeling.Feeling;
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

        pulsatorLayout.setColor(feeling.getResourceColor());
        pulsatorLayout.start();
    }

}
