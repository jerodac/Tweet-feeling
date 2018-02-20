package br.eng.jerodac.tweetfeeling.tests;

import org.junit.Test;

import static br.eng.jerodac.tweetfeeling.robots.SearchTweetTagRobot.FIELD_TWEET_TAG;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
public class SearchTweetTagTest extends BaseTest {

    @Test
    public void testScreenComponents() {
        ROBOT.getSearchTweetTagRobot()
                .assertFragmentInstance()
                .checkElementsScreen();
    }

    @Test
    public void testSearchTweetTagEmptyField() {
        ROBOT.getSearchTweetTagRobot()
                .insertTweetTag("")
                .tapSearchButton()
                .validateErrorEmptyField();
    }

    @Test
    public void testSearchTweetTagField() {
        ROBOT.getSearchTweetTagRobot()
                .insertTweetTag(FIELD_TWEET_TAG)
                .tapSearchButton()
                .checkField();
    }

    @Test
    public void testValidateController() {
        ROBOT.getSearchTweetTagRobot()
                .insertTweetTag(FIELD_TWEET_TAG)
                .tapSearchButton()
                .assertController();
    }

    @Test
    public void testCheckFragmentHeap() {
        ROBOT.getSearchTweetTagRobot()
                .insertTweetTag(FIELD_TWEET_TAG)
                .tapSearchButton()
                .assertFragmentHeap();
    }

}
