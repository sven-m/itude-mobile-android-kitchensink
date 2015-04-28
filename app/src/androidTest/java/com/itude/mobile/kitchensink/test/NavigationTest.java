package com.itude.mobile.kitchensink.test;

import android.support.test.espresso.assertion.ViewAssertions;
import android.test.ActivityInstrumentationTestCase2;

import com.itude.mobile.mobbl.core.controller.MBDefaultViewManager;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class NavigationTest extends ActivityInstrumentationTestCase2<MBDefaultViewManager> {

    public NavigationTest() {
        super(MBDefaultViewManager.class);
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        getActivity();
    }

    public void testTheUserCanTryTheNavigationExamples() throws InterruptedException {
        Thread.sleep(1500);
        onView(withText("MOBBL Examples")).check(ViewAssertions.matches(isDisplayed()));
        onView(withText("Page navigation via row.")).perform(click());
        onView(withText("Hello World")).check(ViewAssertions.matches(isDisplayed()));
        pressBack();
        onView(withText("Page navigation via row.")).check(ViewAssertions.matches(isDisplayed()));
    }
}
