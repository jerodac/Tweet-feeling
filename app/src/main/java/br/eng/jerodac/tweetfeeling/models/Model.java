package br.eng.jerodac.tweetfeeling.models;

import com.twitter.sdk.android.core.models.Tweet;

import br.eng.jerodac.tweetfeeling.bussiness.Feeling;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class Model {
    private String tweetTag;
    private Tweet tweet;
    private float magnitudeFeeling;
    private float scoreFeeling;

    public String getTweetTag() {
        return tweetTag;
    }

    public String getDisplayTweetTag() {
        return "#" + getTweetTag();
    }

    public void setTweetTag(String tweetTag) {
        this.tweetTag = tweetTag;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }

    public float getMagnitudeFeeling() {
        return magnitudeFeeling;
    }

    public void setMagnitudeFeeling(float magnitudeFeeling) {
        this.magnitudeFeeling = magnitudeFeeling;
    }

    public float getScoreFeeling() {
        return scoreFeeling;
    }

    public void setScoreFeeling(float scoreFeeling) {
        this.scoreFeeling = scoreFeeling;
    }

    public Feeling getFeeling() {
        Feeling feeling = Feeling.HAPPY;
        if (getScoreFeeling() <= 0.33f) {
            feeling = Feeling.SAD;
        } else if (getScoreFeeling() <= 0.66f) {
            feeling = Feeling.NEUTRAL;
        }
        return feeling;
    }
}
