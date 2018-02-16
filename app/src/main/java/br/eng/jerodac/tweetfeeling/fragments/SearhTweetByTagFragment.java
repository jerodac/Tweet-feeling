package br.eng.jerodac.tweetfeeling.fragments;

import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;

import br.eng.jerodac.tweetfeeling.R;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Eng. Jean Rodrigo Dalbon Cunha on 16/02/2018.
 */
public class SearhTweetByTagFragment extends BaseFragment {

    public static SearhTweetByTagFragment newInstance(){
        return new SearhTweetByTagFragment();
    }

    @BindView(R.id.input_layout_tag)
    protected TextInputLayout inputLayoutTag;

    @BindView(R.id.edt_tag)
    protected AppCompatEditText edtTag;

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.searh_tweets_fragment;
    }

    @Override
    protected void initComponents(View rootView) {

    }

    private boolean validateField() {
        if (edtTag.getText().toString().equals("")) {
            inputLayoutTag.setErrorEnabled(true);
            inputLayoutTag.setError("Please insert a tweet tag ;)");
        }
        return true;
    }

    @OnClick(R.id.btn_search_tweets)
    void onSearchTweets() {
        if (validateField()) {
            getController().setTagTweet(edtTag.getText().toString());
            getFlowManager().replace(ListTweetsFragment.newInstance(), true);
        }
    }

    @Override
    protected void settings(View rootView) {

    }
}
