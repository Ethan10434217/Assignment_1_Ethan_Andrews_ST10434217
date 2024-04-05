import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.assignment1ethanandrewsst10434217.MainActivity
import org.junit.Rule
import org.junit.Test

class AndroidTestUnit {

    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun enterValidAge_ShowEvent() {
        val validAge = "1976"
        onView(withId(R.id.edtUserAge)).perform(typeText(validAge))
        onView(withId(R.id.btnGenerateData)).perform(click())
        onView(withId(R.id.txtData)).check(matches(withText("In 1976: Declaration of independence in the United States")))
    }

    @Test
    fun enterInvalidAge_ShowErrorMessage() {
        val invalidAge = "abc"
        onView(withId(R.id.edtUserAge)).perform(typeText(invalidAge))
        onView(withId(R.id.btnGenerateData)).perform(click())
        onView(withId(R.id.txtData)).check(matches(withText("No event has been found from your input")))
    }

    // Add more tests as needed
}
