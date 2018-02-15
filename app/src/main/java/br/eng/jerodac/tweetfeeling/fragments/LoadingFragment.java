package br.eng.jerodac.tweetfeeling.fragments;

import android.view.View;
import android.widget.Toast;

import br.eng.jerodac.tweetfeeling.R;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class LoadingFragment extends BaseFragment {

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.loader_fragment;
    }

    @Override
    protected void initComponents(View rootView) {

    }

    @Override
    protected void settings(View rootView) {

    }
}
