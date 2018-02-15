package br.eng.jerodac.tweetfeeling;

import android.os.Bundle;

import br.eng.jerodac.tweetfeeling.fragments.LoadingFragment;

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
            getFlowManager().replace(new LoadingFragment(), false);
        }
    }
}
