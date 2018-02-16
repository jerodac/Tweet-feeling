package br.eng.jerodac.tweetfeeling.models;

import com.twitter.sdk.android.core.models.Tweet;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class Model {
    private String tweetTag;
    private Tweet tweet;

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
}
