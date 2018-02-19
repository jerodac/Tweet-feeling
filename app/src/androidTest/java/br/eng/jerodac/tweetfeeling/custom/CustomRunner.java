package br.eng.jerodac.tweetfeeling.custom;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnitRunner;

public class CustomRunner extends AndroidJUnitRunner {
    @Override
    public void onCreate(Bundle arguments) {
        super.onCreate(arguments);
        System.setProperty("dexmaker.dexcache", getTargetContext().getCacheDir().toString());
    }
}
