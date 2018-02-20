package br.eng.jerodac.tweetfeeling.robots;

import android.widget.ListView;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.controllers.MainController;
import br.eng.jerodac.tweetfeeling.custom.UIAutomation;
import br.eng.jerodac.tweetfeeling.fragments.ListTweetsFragment;
import br.eng.jerodac.tweetfeeling.util.TestUtils;

import static android.os.SystemClock.sleep;

/**
 * Created by Jeaan Rodrigo Dalbon Cunha on 20/02/2018.
 */
public class ListTweetsRobot {

    public ListTweetsRobot insertTweetTag() {
        UIAutomation.inputTextById(R.id.edt_tag, "Android");
        UIAutomation.clickById(R.id.btn_search_tweets);
        return this;
    }

    public ListTweetsRobot checkToolbarTitle() {
        UIAutomation.checkTextIsDisplayed("#Android");
        return this;
    }

    public ListTweetsRobot checkElements() {
        UIAutomation.checkIdIsDisplayed(R.id.loader);
        return this;
    }

    public ListTweetsRobot assertPopulateTweetList() {
        ListView listView = TestUtils.getViewByFragment(ListTweetsFragment.class).findViewById(android.R.id.list);
        assert (listView.getCount() > 0);
        return this;
    }

    public ListTweetsRobot clickItemList(int position) {
        //sleep necessary because lib twitter
        sleep(6000);
        UIAutomation.clickListViewItem(position);
        return this;
    }

    public ListTweetsRobot assertController() {
        assert (MainController.getInstance().getModel().getTweet() != null);
        return this;
    }

    public ListTweetsRobot assertFragmentInstance() {
        assert (TestUtils.checkFragmentIsVisible(ListTweetsFragment.class));
        return this;
    }

    public ListTweetsRobot assertFragmentHeap(int count) {
        assert (TestUtils.getFragmentsCount() == count);
        return this;
    }
}
