package br.eng.jerodac.tweetfeeling;

import android.os.Bundle;

import br.eng.jerodac.tweetfeeling.fragments.SearchTweetByTagFragment;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            getFlowManager().replace(SearchTweetByTagFragment.newInstance(), false);
        }

//        Intent i = new Intent(getBaseContext(), TimelineActivity.class);
//        startActivity(i);
    }
}
