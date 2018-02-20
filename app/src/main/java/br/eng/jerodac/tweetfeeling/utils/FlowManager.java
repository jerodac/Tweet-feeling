package br.eng.jerodac.tweetfeeling.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import br.eng.jerodac.tweetfeeling.BaseActivity;
import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.fragments.BaseFragment;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class FlowManager {

    private BaseActivity mActivity;
    private int mContainer = R.id.fragment_container;
    private int mContainerChild = R.id.fragment_container_child;
    private static FragmentManager mFragmentManager;

    public FlowManager(BaseActivity appCompatActivity) {
        mActivity = appCompatActivity;
        mFragmentManager = mActivity.getSupportFragmentManager();
    }

    //Adding Fragment
    public void add(BaseFragment addFragment) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.add(mContainer, addFragment, addFragment.getTagName());
        ft.addToBackStack(null);
        ft.commit();
    }

    public void replaceChildFragment(FragmentManager childFragmentManager, BaseFragment fragment) {
        childFragmentManager
                .beginTransaction()
                .replace(mContainerChild, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commitAllowingStateLoss();
    }

    //Replace Fragment
    public void replace(Fragment newFragment, boolean backStack) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(mContainer, newFragment, "");
        if (backStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

    public static FragmentManager getFragmentManager(){
        return mFragmentManager;
    }

}
