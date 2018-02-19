package br.eng.jerodac.tweetfeeling.custom;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.util.Log;
import android.view.View;

import org.hamcrest.Matcher;

public class CustomEspresso {

    private static int sDelay = 0;
    private static int sBeginDelay = 0;
    private static int sFinishDelay = 0;

    public static void setDelay(int delay) {
        sDelay = delay;
    }

    public static ViewInteraction onView(final Matcher<View> viewMatcher) {
        Log.d("DELAY", "INTERACTION WITH DELAY OF " + sDelay + "ms");
        ViewInteraction interaction = Espresso.onView(viewMatcher);
        if (sDelay > 0) {
            try {
                Thread.sleep(sDelay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return interaction;
    }

    public static void setBeginDelay(int beginDelay) {
        sBeginDelay = beginDelay;
    }

    public static void setFinishDelay(int finishDelay) {
        sFinishDelay = finishDelay;
    }

    public static int getBeginDelay() {
        return sBeginDelay;
    }

    public static int getFinishDelay() {
        return sFinishDelay;
    }
}
