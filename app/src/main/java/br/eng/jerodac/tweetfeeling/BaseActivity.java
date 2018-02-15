package br.eng.jerodac.tweetfeeling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.eng.jerodac.tweetfeeling.utils.FlowManager;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Flow Manager
     */
    private static FlowManager mFlowManager;

    public FlowManager getFlowManager() {
        return mFlowManager;
    }

    private void initComponents() {
        mFlowManager = new FlowManager(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }
}
