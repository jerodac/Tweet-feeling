package br.eng.jerodac.tweetfeeling.bussiness;

import br.eng.jerodac.tweetfeeling.R;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public enum Feeling {

    HAPPY(R.drawable.ic_emoji_happy1,
            R.drawable.ic_emoji_happy2,
            R.drawable.ic_emoji_happy3,
            R.color.color_feeling_happy,
            R.color.color_feeling_happy_dark,
            R.string.twitter_feeling_happy),

    NEUTRAL(R.drawable.ic_emoji_neutral1,
            R.drawable.ic_emoji_neutral2,
            R.drawable.ic_emoji_neutral3,
            R.color.color_feeling_neutral,
            R.color.color_feeling_neutral_dark,
            R.string.twitter_feeling_neutral),

    SAD(R.drawable.ic_emoji_sad1,
            R.drawable.ic_emoji_sad2,
            R.drawable.ic_emoji_sad3,
            R.color.color_feeling_sad,
            R.color.color_feeling_sad_dark,
            R.string.twitter_feeling_sad);

    Feeling(int resource1, int resource2, int resource3, int colorResource, int colorResourceDark, int resourceString) {
        mResourceImage1 = resource1;
        mResourceImage2 = resource2;
        mResourceImage3 = resource3;
        mResourceColor = colorResource;
        mResourceColorDark = colorResourceDark;
        mResourceString = resourceString;
    }

    private int mResourceImage1;
    private int mResourceImage2;
    private int mResourceImage3;
    private int mResourceColor;
    private int mResourceColorDark;
    private int mResourceString;

    public int getResourceImage1() {
        return mResourceImage1;
    }

    public int getResourceImage2() {
        return mResourceImage2;
    }

    public int getResourceImage3() {
        return mResourceImage3;
    }

    public int getResourceColor() {
        return mResourceColor;
    }

    public int getmResourceColorDark() {
        return mResourceColorDark;
    }

    public int getResourceString() {
        return mResourceString;
    }

}