package br.eng.jerodac.tweetfeeling.utils;

import com.luolc.emojirain.EmojiRainLayout;

import br.eng.jerodac.tweetfeeling.Feeling;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class AnimationSuite {

    public static void feelingAnimation(EmojiRainLayout emojiCOntainer, Feeling feeling) {
        emojiCOntainer.addEmoji(feeling.getResourceImage1());
        emojiCOntainer.addEmoji(feeling.getResourceImage2());
        emojiCOntainer.addEmoji(feeling.getResourceImage3());
        emojiCOntainer.startDropping();
    }

}
