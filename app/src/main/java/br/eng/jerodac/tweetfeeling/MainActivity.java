package br.eng.jerodac.tweetfeeling;

import android.content.Intent;
import android.os.Bundle;

import br.eng.jerodac.tweetfeeling.fragments.FeelingTweetFragment;
import br.eng.jerodac.tweetfeeling.fragments.ListTweetsFragment;
import br.eng.jerodac.tweetfeeling.fragments.LoadingFragment;
import br.eng.jerodac.tweetfeeling.fragments.SearhTweetByTagFragment;

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
            getFlowManager().replace(new FeelingTweetFragment(), false);
        }

//        Intent i = new Intent(getBaseContext(), TimelineActivity.class);
//        startActivity(i);
    }
}
