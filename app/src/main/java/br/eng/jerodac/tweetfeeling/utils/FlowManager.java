package br.eng.jerodac.tweetfeeling.utils;

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
    private FragmentManager mFragmentManager;

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

    //Replace Fragment
    public void replace(BaseFragment newFragment, boolean backStack) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.replace(mContainer, newFragment, newFragment.getTagName());
        if (backStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }

}
