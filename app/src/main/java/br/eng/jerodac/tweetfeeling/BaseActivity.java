package br.eng.jerodac.tweetfeeling;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import br.eng.jerodac.tweetfeeling.utils.FlowManager;

/**
 * Created by Jean Rodrigo Dalbon Cunha on 15/02/2018.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Flow Manager
     */
    private static FlowManager mFlowManager;

    /**
     * Toolbar
     */
    public Toolbar mToolbar;

    private void initComponents() {
        mFlowManager = new FlowManager(this);
        mToolbar = findViewById(R.id.toolbar);
    }

    public FlowManager getFlowManager() {
        return mFlowManager;
    }

    public Toolbar getToolbar() {
        return mToolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }
}