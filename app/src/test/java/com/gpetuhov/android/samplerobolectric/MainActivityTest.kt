package com.gpetuhov.android.samplerobolectric

import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule val rule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun checkMainLogic() {
        // This test needs no Android device or emulator.
        // All Android stuff is mocked by Robolectric.

        // Now we can write our unit test like an Espresso Android test, but it runs on JVM
        onView(withText(R.string.hello)).check(matches(isClickable()))

        // Or we can use Robolectric style:
        val activity = rule.activity
        val textView: TextView = activity.findViewById(R.id.textView)
        assertEquals(textView.text.toString(), "Hello World!")

        textView.performClick()
        assertEquals(textView.text.toString(), "Clicked")
    }
}