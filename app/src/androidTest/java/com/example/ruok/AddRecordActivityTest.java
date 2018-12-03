package com.example.ruok;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.app.Activity;
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;


import com.example.ruok.activities.AddProblemActivity;
import com.example.ruok.activities.AddRecordActivity;
import com.example.ruok.activities.RecordPageActivity;

import com.example.ruok.ui.RecordListActivity;
import com.robotium.solo.Solo;

import androidx.test.espresso.intent.rule.IntentsTestRule;


public class AddRecordActivityTest extends ActivityInstrumentationTestCase2{
    private Solo solo;
    public  AddRecordActivityTest () {
        super( AddRecordActivity.class);
    }

    @Rule
    public IntentsTestRule<AddRecordActivity> intentsTestRule =
            new IntentsTestRule<>(AddRecordActivity.class);


    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(), getActivity());
    }
    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }
    @Test
    public void submit() {

        onView(withId(R.id.addProblemBack)).perform(click());
    }


    }
