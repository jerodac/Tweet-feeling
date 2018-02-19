package br.eng.jerodac.tweetfeeling.custom;

import android.graphics.Rect;
import android.support.annotation.IntDef;
import android.support.test.espresso.PerformException;
import android.support.test.espresso.Root;
import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.CoordinatesProvider;
import android.support.test.espresso.action.GeneralClickAction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.action.Tap;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.espresso.util.HumanReadables;
import android.support.test.espresso.util.TreeIterables;
import android.text.InputType;
import android.text.Layout;
import android.text.SpannableString;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TabHost;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.TimeoutException;

import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;


public class CustomMatcher {

    public static Matcher<View> isOnScreen() {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("is placed on the current screen to the user");
            }

            @Override
            public boolean matchesSafely(View view) {
                return withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE).matches(view);
            }
        };
    }

    public static Matcher<View> instanceOfView(Class<? extends View> type) {
        return IsInstanceOfView.instanceOf(type);
    }


    public static ViewAction setText(final String stringToBeTyped) {
        return new ViewAction() {

            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed(), ViewMatchers.supportsInputMethods());
            }

            @Override
            public String getDescription() {
                return " set text as ";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ((EditText) view).setText(stringToBeTyped);
            }
        };
    }

    public static Matcher<View> isPassword() {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof EditText)) {
                    return false;
                }
                int type = ((EditText) view).getInputType();
                return (type & InputType.TYPE_TEXT_VARIATION_PASSWORD) > 0;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(" is not a password field! ");
            }
        };
    }

    public static Matcher<View> isSetAt(final int value) {
        return new TypeSafeMatcher<View>() {

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof ProgressBar)) {
                    return false;
                }
                return ((ProgressBar) view).getProgress() == value;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(" does not has progress set at " + value + "! ");
            }
        };
    }

    public static Matcher<View> hasMax(final int value) {
        return new TypeSafeMatcher<View>() {
            public static final String TAG = "RegisterScreen";

            @Override
            public boolean matchesSafely(View view) {
                if (!(view instanceof ProgressBar)) {
                    return false;
                }
                int mMax = ((ProgressBar) view).getMax();
                Log.d(TAG, "matchesSafely " + mMax);
                return mMax == value;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(" does not have max set for " + value + "! ");
            }
        };
    }

    public static ViewAction setFocus() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed());
            }

            @Override
            public String getDescription() {
                return "set focus";
            }

            @Override
            public void perform(UiController uiController, View view) {
                view.requestFocus();
            }
        };
    }

    public static ViewAction findAndClick() {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isOnScreen());
            }

            @Override
            public String getDescription() {
                return "click";
            }

            @Override
            public void perform(UiController uiController, View view) {
                closeSoftKeyboard().perform(uiController, view);
                ViewActions.scrollTo().perform(uiController, view);
                ViewActions.click().perform(uiController, view);
            }
        };
    }

    public static ViewAction findClickAndType(final String text) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isOnScreen());
            }

            @Override
            public String getDescription() {
                return "click";
            }

            @Override
            public void perform(UiController uiController, View view) {
                ViewActions.scrollTo().perform(uiController, view);
                ViewActions.click().perform(uiController, view);
                ViewActions.typeText(text).perform(uiController, view);
            }
        };
    }

    public static ViewAction clickOnWord(final String word) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return allOf(isDisplayed());
            }

            @Override
            public String getDescription() {
                return " click on " + word;
            }

            @Override
            public void perform(UiController uiController, View view) {
                SpannableString span = (SpannableString) ((TextView) view).getText();
                String completeText = ((TextView) view).getText().toString();
                Layout textViewLayout = ((TextView) view).getLayout();

                int endOffsetOfClickedText = completeText.indexOf(word) + word.length();
                float endXCoordinatesOfClickedText = textViewLayout.getPrimaryHorizontal(endOffsetOfClickedText);

                int clickedTextLine = textViewLayout.getLineForOffset(endOffsetOfClickedText);
                int yEndCoordinateOfClickedText = textViewLayout.getLineBottom(clickedTextLine);

                clickXY(Float.valueOf(endXCoordinatesOfClickedText).intValue(), yEndCoordinateOfClickedText / 2)
                        .perform(uiController, view);
            }
        };
    }

    public static ViewAction clickXY(final int x, final int y) {
        return new GeneralClickAction(
                Tap.SINGLE,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);

                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};

                        return coordinates;
                    }
                },
                Press.FINGER);
    }

    public static ViewAction clickOnPortion(@ViewPortion final int portion, final int margin) {
        return new GeneralClickAction(
                Tap.SINGLE,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);
                        Rect bounds = new Rect();
                        view.getDrawingRect(bounds);
                        int x = bounds.width() / 2;
                        int y = bounds.height() / 2;
                        switch (portion) {
                            case Gravity.LEFT:
                                x = margin;
                                break;
                            case Gravity.TOP:
                                y = margin;
                                break;
                            case Gravity.RIGHT:
                                x = bounds.width() - margin;
                                break;
                            case Gravity.BOTTOM:
                                y = bounds.height() - margin;
                                break;
                        }
                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};

                        return coordinates;
                    }
                },
                Press.FINGER);
    }

    public static ViewAction swipeDown() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_CENTER,
                GeneralLocation.BOTTOM_CENTER, Press.FINGER);
    }

    public static ViewAction swipeUp() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }

    public static ViewAction swipeRight(Swipe swipeMode) {
        return new GeneralSwipeAction(swipeMode, GeneralLocation.CENTER_LEFT,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    public static ViewAction swipeLeft(Swipe swipeMode) {
        return new GeneralSwipeAction(swipeMode, GeneralLocation.CENTER_RIGHT,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }

    public static ViewAction swipeRightFromCenter(Swipe swipeMode) {
        return new GeneralSwipeAction(swipeMode, GeneralLocation.CENTER,
                GeneralLocation.CENTER_RIGHT, Press.FINGER);
    }

    public static ViewAction swipeLeftFromCenter(Swipe swipeMode) {
        return new GeneralSwipeAction(swipeMode, GeneralLocation.CENTER,
                GeneralLocation.CENTER_LEFT, Press.FINGER);
    }

    public static Matcher<View> childAtPosition(final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    public static Matcher<View> withDrawable(final int resourceId) {
        return new DrawableMatcher(resourceId);
    }

    public static Matcher<View> noDrawable() {
        return new DrawableMatcher(-1);
    }

    public static ViewAction waitId(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child)) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };

    }

    public static Matcher<Root> isPopupWindow() {
        return isPlatformPopup();
    }

    public static Matcher<View> TabMatcher(final Matcher<View> parentMatcher, final int index) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View view) {
                if (!(view.getParent() instanceof TabHost)) {
                    return parentMatcher.matches(view.getParent());
                }
                TabHost tabHost = (TabHost) view.getParent();
                return parentMatcher.matches(view.getParent())
                        && tabHost.getTabContentView().getChildCount() > index &&
                        tabHost.getTabContentView().getChildAt(index) != null;
            }

            @Override
            public void describeTo(Description description) {

            }
        };
    }

    @IntDef({Gravity.LEFT, Gravity.TOP, Gravity.RIGHT, Gravity.BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ViewPortion {
    }

}
