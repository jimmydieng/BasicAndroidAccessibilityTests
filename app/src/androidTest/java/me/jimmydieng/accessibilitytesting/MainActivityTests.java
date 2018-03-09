package me.jimmydieng.accessibilitytesting;


import android.support.test.espresso.accessibility.AccessibilityChecks;
import android.support.test.rule.ActivityTestRule;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class MainActivityTests {

  @Rule
  public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

  @BeforeClass
  public static void enableAccessibilityChecks() {
    AccessibilityChecks.enable()
            .setRunChecksFromRootView(true);
  }

  @Test
  public void testText() {
    onView(withId(R.id.main_text))
            .check(matches(isDisplayed()));

    onView(withId(R.id.imageButton1)).perform(click());

    // assertions
    onView(withId(R.id.imageButton3)).check(matches(isDisplayed()));
  }
}
