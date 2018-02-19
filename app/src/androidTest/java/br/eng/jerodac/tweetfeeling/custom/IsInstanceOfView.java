package br.eng.jerodac.tweetfeeling.custom;

import android.view.View;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsInstanceOfView extends BaseMatcher<View> {
    private final Class<? extends View> theClass;

    public IsInstanceOfView(Class<? extends View> theClass) {
        this.theClass = theClass;
    }

    public boolean matches(Object item) {
        return this.theClass.isInstance(item);
    }

    public void describeTo(Description description) {
        description.appendText("an instance of ").appendText(this.theClass.getName());
    }

    @Factory
    public static Matcher<View> instanceOf(Class<? extends View> type) {
        return new IsInstanceOfView(type);
    }
}

