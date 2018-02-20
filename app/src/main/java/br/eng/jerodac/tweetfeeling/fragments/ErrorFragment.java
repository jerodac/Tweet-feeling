package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;

import br.eng.jerodac.tweetfeeling.R;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 20/02/2018.
 */
public class ErrorFragment extends BaseFragment {

    public static ErrorFragment newInstance() {
        return new ErrorFragment();
    }

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.error_screen;
    }

    @Override
    protected void initComponents(View rootView) {

    }

    @Override
    protected void settings(View rootView) {

    }
}
