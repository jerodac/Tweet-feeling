package br.eng.jerodac.tweetfeeling.custom;


import android.support.annotation.IdRes;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.Swipe;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.view.KeyEvent;

import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.pressKey;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static br.eng.jerodac.tweetfeeling.custom.CustomEspresso.onView;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.childAtPosition;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.isPassword;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.isPopupWindow;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeDown;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeLeft;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeLeftFromCenter;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeRight;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeRightFromCenter;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.swipeUp;
import static br.eng.jerodac.tweetfeeling.custom.CustomMatcher.waitId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.not;

/**
 * Created by nyoshida on 18/02/2016.
 */
public class UIAutomation {

    // Assertions
    public static void checkTextIsDisplayed(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(matches(isDisplayed()));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(matches(isDisplayed()));
        }
    }

    public static void checkIdIsDisplayed(int id) {
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public static void checkIdIsNotDisplayed(int id) {
        onView(withId(id)).check(matches(not(isDisplayed())));
    }

    public static void checkHintIsDisplayed(Object text) {
        if (text instanceof String) {
            onView(withHint((String) text)).check(matches(isDisplayed()));
        } else if (text instanceof Integer) {
            onView(withHint((Integer) text)).check(matches(isDisplayed()));
        }
    }

    public static void checkTextNotDisplayed(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(matches(not(isDisplayed())));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(matches(not(isDisplayed())));
        }
    }

    public static void checkTextById(int id, Object text) {
        if (text instanceof String) {
            onView(withId(id)).check(matches(withText((String) text)));
        } else if (text instanceof Integer) {
            onView(withId(id)).check(matches(withText((Integer) text)));
        }
    }


    public static void checkTextDoesNotExist(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(doesNotExist());
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(doesNotExist());
        }
    }

    public static void checkIdDoesNotExist(int id) {
        onView(withId(id)).check(doesNotExist());
    }

    public static void checkTextIsEnabled(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(matches(isEnabled()));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(matches(isEnabled()));
        }
    }

    public static void checkTextNotEnabled(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(matches(not(isEnabled())));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(matches(not(isEnabled())));
        }
    }

    // Input text
    public static void inputTextByHint(Object hint, String inputText) {
        if (hint instanceof String) {
            onView(withHint((String) hint)).perform(typeText(inputText));
        } else if (hint instanceof Integer) {
            onView(withHint((Integer) hint)).perform(typeText(inputText));
        }
    }

    public static void inputTextById(int id, String inputText) {
        onView(withId(id)).perform(typeText(inputText));
    }

    //Manager elements
    public static void scrollToByText(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).perform(scrollTo());
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).perform(scrollTo());
        }
    }


    public static void scrollToByHint(Object hint) {
        if (hint instanceof String) {
            onView(withHint((String) hint)).perform(scrollTo());
        } else if (hint instanceof Integer) {
            onView(withHint((Integer) hint)).perform(scrollTo());
        }
    }

    public static void scrollToById(int id) {
        onView(withId(id)).perform(scrollTo());
    }

    public static void closeKeyboardById(int id) {
        onView(withId(id)).perform(closeSoftKeyboard());
    }

    // Click button
    public static void clickByText(Object text) {
        if (text instanceof String) {
            onView(allOf(isDisplayed(), withText((String) text))).perform(click());
        } else if (text instanceof Integer) {
            onView(allOf(isDisplayed(), withText((Integer) text))).perform(click());
        }
    }

    // Click button
    public static void clickByHint(Object text) {
        if (text instanceof String) {
            onView(withHint((String) text)).perform(click());
        } else if (text instanceof Integer) {
            onView(withHint((Integer) text)).perform(click());
        }
    }

    // Click button
    public static void clickById(int id) {
        onView(withId(id)).perform(click());
    }

    //Click item menu by description
    public static void clickItemMenuByDescription(Object text) {
        if (text instanceof String) {
            onView(withContentDescription((String) text)).perform(click());
        } else {
            onView(withContentDescription((Integer) text)).perform(click());
        }
    }

    // Back button
    public static void pressBackButton(Object text) {
        onView(withText((String) text)).perform(pressKey(KeyEvent.KEYCODE_BACK));
    }

    //backspace
    public static void backspaceByText(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).perform(pressKey(KeyEvent.KEYCODE_DEL));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).perform(pressKey(KeyEvent.KEYCODE_DEL));
        }
    }


    public static void backspaceByHint(Object text) {
        if (text instanceof String) {
            onView(withHint((String) text)).perform(pressKey(KeyEvent.KEYCODE_DEL));
        } else if (text instanceof Integer) {
            onView(withHint((Integer) text)).perform(pressKey(KeyEvent.KEYCODE_DEL));
        }
    }

    // Clear
    public static void clearFieldByText(Object hint) {
        if (hint instanceof String) {
            onView(withText((String) hint)).perform(clearText());
        } else if (hint instanceof Integer) {
            onView(withText((Integer) hint)).perform(clearText());
        }
    }


    public static void clearFieldByHint(Object hint) {
        if (hint instanceof String) {
            onView(withHint((String) hint)).perform(clearText());
        } else if (hint instanceof Integer) {
            onView(withHint((Integer) hint)).perform(clearText());
        }
    }

    // isSomething
    public static void isPasswordByHint(Object hint) {
        if (hint instanceof String) {
            onView(withHint((String) hint)).check(matches(isPassword()));
        } else if (hint instanceof Integer) {
            onView(withHint((Integer) hint)).check(matches(isPassword()));
        }
    }

    public static void isNotPasswordByHint(Object hint) {
        if (hint instanceof String) {
            onView(withHint((String) hint)).check(matches(not(isPassword())));
        } else if (hint instanceof Integer) {
            onView(withHint((Integer) hint)).check(matches(not(isPassword())));
        }
    }

    public static void isCheckedByText(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).check(matches(isChecked()));
        } else if (text instanceof Integer) {
            onView(withText((Integer) text)).check(matches(isChecked()));
        }
    }

    public static void isCheckedById(int id) {
        onView(withId(id)).check(matches(isChecked()));
    }

    public static void isNotCheckedById(int id) {
        onView(withId(id)).check(matches(isNotChecked()));
    }

    //Gestures
    public static void swipeTopToBottom(int id) {
        onView(withId(id)).perform(swipeDown());
    }

    public static void swipeToRight(Swipe swipeMode, int id) {
        onView(withId(id)).perform(swipeRight(swipeMode));
    }

    public static void swipeToRightFromCenter(Swipe swipeMode, int id) {
        onView(withId(id)).perform(swipeRightFromCenter(swipeMode));
    }

    public static void swipeToLeft(Swipe swipeMode, int id) {
        onView(withId(id)).perform(swipeLeft(swipeMode));
    }

    public static void swipeToLeftFromCenter(Swipe swipeMode, int id) {
        onView(withId(id)).perform(swipeLeftFromCenter(swipeMode));
    }

    public static void swipeToLeftFromCenter(Swipe swipeMode, int id, int amount) {
        for (int i = 0; i < amount; i++) {
            swipeToLeftFromCenter(swipeMode, id);
        }
    }

    public static void swipeTopToUp(int id) {
        onView(withId(id)).perform(swipeUp());
    }

    // wait Element
    public static void waitElementId(int id, long time) {
        onView(isRoot()).perform(waitId(id, TimeUnit.SECONDS.toMillis(time)));
    }

    // PopUp Window Instrumentation
    public static void clickByTextPopUpWindow(Object text) {
        if (text instanceof String) {
            onView(withText((String) text)).inRoot(isPopupWindow()).perform(click());
        } else {
            onView(withText((Integer) text)).inRoot(isPopupWindow()).perform(click());
        }

    }

    //click view in PopUpMenuWindow
    public static void clickByIdPopUpWindow(int id) {
        onView(withId(id)).inRoot(isPopupWindow()).perform(click());
    }


    //Instrumentation elements multiple hierarchy
    public static void checkSpecifTextInIdDisplayed(int id, String text) {
        onView(allOf(withId(id), withText(text), isDisplayed()));
    }


    public static void clickSpecifTextInId(int id, String text) {
        onView(allOf(withId(id), withText(text), isDisplayed())).perform(click());
    }


    public static void scroll(int id, int posChild, int posRecy, String text) {

        ViewInteraction recyclerView = Espresso.onView(
                allOf(withId(id),
                        childAtPosition(withClassName(Matchers.is(text)),
                                posChild)));
        recyclerView.perform(actionOnItemAtPosition(posRecy, click()));

    }

    public static void clickRecyclerViewItem(@IdRes int recyclerId, int item) {
        onView(withId(recyclerId)).perform(RecyclerViewActions.actionOnItemAtPosition(item, click()));
    }

    public static void clickListViewItem(int position) {
        onData(anything()).inAdapterView(withId(android.R.id.list)).atPosition(position).perform(click());
    }
}