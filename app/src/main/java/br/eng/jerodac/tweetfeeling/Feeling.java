package br.eng.jerodac.tweetfeeling;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public enum Feeling {
    HAPPY(R.drawable.ic_emoji_happy1, R.drawable.ic_emoji_happy2, R.drawable.ic_emoji_happy3, R.string.twitter_feeling_happy),
    NEUTRAL(R.drawable.ic_emoji_neutral1, R.drawable.ic_emoji_neutral2, R.drawable.ic_emoji_neutral3, R.string.twitter_feeling_neutral),
    SAD(R.drawable.ic_emoji_sad1, R.drawable.ic_emoji_sad2, R.drawable.ic_emoji_sad3, R.string.twitter_feeling_sad);

    Feeling(int resource1, int resource2, int resource3, int resource4) {
        resourceImage1 = resource1;
        resourceImage2 = resource2;
        resourceImage3 = resource3;
        resourceString = resource4;
    }

    private int resourceImage1;
    private int resourceImage2;
    private int resourceImage3;
    private int resourceString;

    public int getResourceImage1() {
        return resourceImage1;
    }

    public int getResourceImage2() {
        return resourceImage2;
    }

    public int getResourceImage3() {
        return resourceImage3;
    }

    public int getResourceString() {
        return resourceString;
    }

    public void setResourceString(int resourceString) {
        this.resourceString = resourceString;
    }
}
