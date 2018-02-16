package br.eng.jerodac.tweetfeeling.models;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class Model {
    private String tweetTag;
    private String tweetText;

    public String getTweetTag() {
        return tweetTag;
    }

    public String getDisplayTweetTag() {
        return "#" + getTweetTag();
    }

    public void setTweetTag(String tweetTag) {
        this.tweetTag = tweetTag;
    }

    public String getTweetText() {
        return tweetText;
    }

    public void setTweetText(String tweetText) {
        this.tweetText = tweetText;
    }
}
