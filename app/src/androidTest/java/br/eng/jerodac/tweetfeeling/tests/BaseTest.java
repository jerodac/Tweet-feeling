package br.eng.jerodac.tweetfeeling.tests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import br.eng.jerodac.tweetfeeling.MainActivity;
import br.eng.jerodac.tweetfeeling.robots.Robot;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 19/02/2018.
 */
@RunWith(AndroidJUnit4.class)
class BaseTest {

    {
        before();
    }

    public void before() {

    }

    public Robot ROBOT = new Robot();

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    public MainActivity getActivity() {
        return mActivityTestRule.getActivity();
    }
}
