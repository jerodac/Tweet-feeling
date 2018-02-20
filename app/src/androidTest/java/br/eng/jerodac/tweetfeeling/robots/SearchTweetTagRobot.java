package br.eng.jerodac.tweetfeeling.robots;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.controllers.MainController;
import br.eng.jerodac.tweetfeeling.custom.UIAutomation;
import br.eng.jerodac.tweetfeeling.fragments.SearchTweetByTagFragment;
import br.eng.jerodac.tweetfeeling.util.TestUtils;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
public class SearchTweetTagRobot {

    public static String FIELD_TWEET_TAG = "Android";

    public SearchTweetTagRobot checkElementsScreen() {
        UIAutomation.checkTextIsDisplayed("Tweet Feeling");
        UIAutomation.checkTextIsDisplayed("Hello, we say a tweet tag to do our research :)");
        UIAutomation.checkTextIsDisplayed("Search");
        return this;
    }

    public SearchTweetTagRobot insertTweetTag(String tweetTag) {
        UIAutomation.inputTextById(R.id.edt_tag, tweetTag);
        return this;
    }

    public SearchTweetTagRobot tapSearchButton() {
        UIAutomation.clickById(R.id.btn_search_tweets);
        return this;
    }

    public SearchTweetTagRobot validateErrorEmptyField() {
        UIAutomation.checkTextIsDisplayed("Please insert a tweet tag ;)");
        return this;
    }

    public SearchTweetTagRobot checkField() {
        UIAutomation.checkTextDoesNotExist("Please insert a tweet tag ;)");
        return this;
    }

    public SearchTweetTagRobot assertController() {
        assert (MainController.getInstance().getModel().getTweetTag().equals(FIELD_TWEET_TAG));
        return this;
    }

    public SearchTweetTagRobot assertFragmentInstance() {
        assert (TestUtils.checkFragmentIsVisible(SearchTweetByTagFragment.class));
        return this;
    }

    public SearchTweetTagRobot assertFragmentHeap() {
        assert (TestUtils.getFragmentsCount() == 1);
        return this;
    }
}