package br.eng.jerodac.tweetfeeling.tests;

import org.junit.Test;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
public class SearchTweetTagTest extends BaseTest {

    @Test
    public void testSearchTweetTagEmptyField() {
        ROBOT.getSearchTweetTagRobot()
                .checkElementsScreen()
                .insertTweetTag("")
                .tapSearchButton()
                .validateErrorEmptyField();
    }

    @Test
    public void testSearchTweetTagField() {

    }

    @Test
    public void testValidateController() {

    }

    @Test
    public void testCheckFragmentHeap() {

    }

}
