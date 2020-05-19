package com.github.crazygit.androidxtestdemo;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    // 必须写
    // An IntentsTestRule initializes Espresso-Intents before each test annotated with @Test and releases Espresso-Intents after each test run.
    @Rule
    public IntentsTestRule<MainActivity> intentsTestRule =
            new IntentsTestRule<>(MainActivity.class);

    @Test
    public void testLogin_with_correct_info() {
        String username = "admin";
        String password = "secret";
        String expectedMsg = "welcome";
        login(username, password, expectedMsg);
    }

    @Test
    public void testLogin_with_incorrect_info() {
        String username = "admin";
        String password = "password";
        String expectedMsg = "wrong";
        login(username, password, expectedMsg);
    }

    public void login(String username, String password, String expectedMsg) {
        // GIVEN
        ActivityScenario.launch(MainActivity.class);

        // WHEN
        onView(withId(R.id.input_username)).perform(typeText(username));
        onView(withId(R.id.input_password)).perform(typeText(password));
        onView(withId(R.id.btn_login)).perform(click());

        // THEN
        intended(hasComponent(UserActivity.class.getName()));
        // 另一种获取Intent的方法
//        List<Intent> intents = getIntents(); // 获取到目前为止运行的所有Intent
//        assertThat(intents.get(intents.size() - 1)).hasComponentClass(UserActivity.class);

        onView(withId(R.id.tv_msg)).check(matches(withText(expectedMsg)));

    }
}