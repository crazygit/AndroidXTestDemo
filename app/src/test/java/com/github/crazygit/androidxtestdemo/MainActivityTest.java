package com.github.crazygit.androidxtestdemo;

import android.os.Build;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


// @Config配置Robolectric
// http://robolectric.org/configuring/
@RunWith(AndroidJUnit4.class)
@Config(sdk = Build.VERSION_CODES.O_MR1)
public class MainActivityTest {

    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void testLogin() {
        String username = "admin";
        String password = "secret";

        // GIVEN
        ActivityScenario scenario = ActivityScenario.launch(MainActivity.class);

        // WHEN
        onView(withId(R.id.input_username)).perform(typeText(username));
        onView(withId(R.id.input_password)).perform(typeText(password));
        onView(withId(R.id.btn_login)).perform(click());

        // THEN
        intended(hasComponent(UserActivity.class.getName()));

        // robolectric不支持Activity跳转，下面的句子要报错
//        onView(withId(R.id.tv_msg)).check(matches(withText("welcome")));
    }


}