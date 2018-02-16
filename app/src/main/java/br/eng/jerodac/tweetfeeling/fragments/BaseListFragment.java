package br.eng.jerodac.tweetfeeling.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.eng.jerodac.tweetfeeling.R;
import br.eng.jerodac.tweetfeeling.controllers.MainController;
import br.eng.jerodac.tweetfeeling.models.Model;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public abstract class BaseListFragment extends ListFragment{

    private Unbinder unbinder;

    protected int getLayoutResource() {
        return 0;
    }

    public abstract String getTagName();

    protected abstract void initComponents(View rootView);

    protected abstract void settings(View rootView);

    public int getTheme() {
        return R.style.AppTheme;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int resourceId = getLayoutResource();
        if (resourceId == 0) {
            return super.onCreateView(inflater, container, savedInstanceState);
        } else {
            //create ContextThemeWrapper from the original Activity Context with the custom theme
            @SuppressLint("RestrictedApi")
            final Context contextThemeWrapper = new ContextThemeWrapper(getActivity(), getTheme());

            // clone the inflater using the ContextThemeWrapper
            LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);

            // inflate the layout using the cloned inflater, not default inflater
            return localInflater.inflate(getLayoutResource(), container, false);
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Após a view ser criada podemos recuperar os componentes de tela
        unbinder = ButterKnife.bind(this, view);
        settings(view);
        initComponents(view);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    protected MainController getController(){
        return MainController.getInstance();
    }

    protected Model getModel(){
        return MainController.getInstance().getModel();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}