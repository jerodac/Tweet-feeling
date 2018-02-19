package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.models.Model;
import br.eng.jerodac.tweetfeeling.presenters.Presenter;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class CheckFeelingTweetFragment extends BaseFragment implements Presenter {

    @Override
    public String getTagName() {
        return getClass().getName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.test;
    }

    @Override
    protected void initComponents(View rootView) {
        getController().analytzText(this);
        getChildFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, new LoadingFragment())
                .commit();
    }

    @Override
    public void onSuccess(Model model) {
        getChildFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.container, new FeelingTweetFragment())
                .commit();
    }

    @Override
    public void onError() {

    }

    @Override
    protected void settings(View rootView) {

    }
}
