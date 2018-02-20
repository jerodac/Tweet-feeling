package br.eng.jerodac.tweetfeeling.tests;

import org.junit.Test;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 20/02/2018.
 */
public class ListTweetsTest extends BaseTest {

    @Test
    public void testValidateScreenComponents() {
        ROBOT.getListTweetRobot()
                .insertTweetTag()
                .assertFragmentInstance()
                .checkToolbarTitle()
                .checkElements();
    }

    @Test
    public void testPopulateListTweets() {
        ROBOT.getListTweetRobot()
                .insertTweetTag()
                .assertPopulateTweetList();
    }

    @Test
    public void testChooseClickItemList() {
        ROBOT.getListTweetRobot()
                .insertTweetTag()
                .clickItemList(2)
                .assertController();
    }

    @Test
    public void testCheckFragmentHeap() {
        ROBOT.getListTweetRobot()
                .insertTweetTag()
                .assertFragmentHeap(2);
    }

}
