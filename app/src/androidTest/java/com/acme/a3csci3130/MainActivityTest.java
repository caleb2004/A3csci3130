package com.acme.a3csci3130;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3598118);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.submitButton), withText("Create Business"), isDisplayed()));
        button.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3594371);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction editText = onView(
                allOf(withId(R.id.name), isDisplayed()));
        editText.perform(replaceText("Evan"), closeSoftKeyboard());

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.businessNumber), isDisplayed()));
        editText2.perform(replaceText("987654321"), closeSoftKeyboard());

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.address), isDisplayed()));
        editText3.perform(replaceText("76 Lonag st"), closeSoftKeyboard());

        ViewInteraction spinner = onView(
                allOf(withId(R.id.province), isDisplayed()));
        spinner.perform(click());

        ViewInteraction checkedTextView = onView(
                allOf(withId(android.R.id.text1), withText("NS"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.app.AlertController$RecycleListView")),
                                        withParent(withClassName(is("android.widget.FrameLayout")))),
                                5),
                        isDisplayed()));
        checkedTextView.perform(click());

        pressBack();

        ViewInteraction spinner2 = onView(
                allOf(withId(R.id.business), isDisplayed()));
        spinner2.perform(click());

        ViewInteraction checkedTextView2 = onView(
                allOf(withId(android.R.id.text1), withText("Distributor"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.app.AlertController$RecycleListView")),
                                        withParent(withClassName(is("android.widget.FrameLayout")))),
                                1),
                        isDisplayed()));
        checkedTextView2.perform(click());

        ViewInteraction button2 = onView(
                allOf(withId(R.id.submitButton), withText("Create Contact"), isDisplayed()));
        button2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3537058);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView = onView(
                allOf(withId(android.R.id.text1), withText("Owen"),
                        childAtPosition(
                                withId(R.id.listView),
                                1),
                        isDisplayed()));
        textView.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3595151);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction spinner3 = onView(
                allOf(withId(R.id.province), isDisplayed()));
        spinner3.perform(click());

        ViewInteraction checkedTextView3 = onView(
                allOf(withId(android.R.id.text1), withText("NU"),
                        childAtPosition(
                                allOf(withClassName(is("com.android.internal.app.AlertController$RecycleListView")),
                                        withParent(withClassName(is("android.widget.FrameLayout")))),
                                7),
                        isDisplayed()));
        checkedTextView3.perform(click());

        ViewInteraction button3 = onView(
                allOf(withId(R.id.updateButton), withText("Update Business"), isDisplayed()));
        button3.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3587483);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction textView2 = onView(
                allOf(withId(android.R.id.text1), withText("Bob"),
                        childAtPosition(
                                withId(R.id.listView),
                                0),
                        isDisplayed()));
        textView2.perform(click());

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(3593498);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button4 = onView(
                allOf(withId(R.id.deleteButton), withText("Erase Business"), isDisplayed()));
        button4.perform(click());

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

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
}
