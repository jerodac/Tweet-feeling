package br.eng.jerodac.tweetfeeling.util;

import android.support.v4.app.Fragment;
import android.view.View;

import java.util.List;

import br.eng.jerodac.tweetfeeling.utils.FlowManager;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 20/02/2018.
 */
public class TestUtils {

    /**
     * check fragment is visible
     */
    public static boolean checkFragmentIsVisible(Class<? extends Fragment> object) {
        List<Fragment> fragments = FlowManager.getFragmentManager().getFragments();

        boolean isVisible = false;

        for (Fragment fragment : fragments) {
            if (fragment.getClass().isAssignableFrom(object)) {
                isVisible = fragment.isVisible();
                break;
            }
        }

        return isVisible;
    }

    /**
     * return view specif fragment
     */
    public static View getViewByFragment(Class<? extends Fragment> object) {
        List<Fragment> fragments = FlowManager.getFragmentManager().getFragments();

        View view = null;

        for (Fragment fragment : fragments) {
            if (fragment.getClass().isAssignableFrom(object)) {
                view = fragment.getView();
                break;
            }
        }

        return view;
    }

    /**
     * return quantity of fragment in heap
     */
    public static int getFragmentsCount() {
        return FlowManager.getFragmentManager().getFragments().size();
    }
}
