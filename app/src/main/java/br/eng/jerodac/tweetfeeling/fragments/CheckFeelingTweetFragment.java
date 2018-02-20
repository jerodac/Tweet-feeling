package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.models.Model;
import br.eng.jerodac.tweetfeeling.presenters.Presenter;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class CheckFeelingTweetFragment extends BaseFragment implements Presenter {

    public static CheckFeelingTweetFragment newInstance() {
        return new CheckFeelingTweetFragment();
    }

    @Override
    public String getTagName() {
        return getClass().getName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.check_feeling_tweet_fragment;
    }

    @Override
    protected void initComponents(View rootView) {
        getController().analytzText(this);
        getFlowManager().replaceChildFragment(getChildFragmentManager(), LoadingFragment.newInstance());
    }

    @Override
    public void onSuccess(Model model) {
        getFlowManager().replaceChildFragment(getChildFragmentManager(), FeelingTweetFragment.newInstance());
    }

    @Override
    public void onError() {

    }

    @Override
    protected void settings(View rootView) {

    }
}
