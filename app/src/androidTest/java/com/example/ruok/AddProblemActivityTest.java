package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.activities.AddProblemActivity;
import com.example.ruok.activities.ProblemListActivity;
import com.robotium.solo.Solo;

import org.junit.Test;

public class AddProblemActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public AddProblemActivityTest() {
        super(AddProblemActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        AddProblemActivity activity = (AddProblemActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be AddProblemActivity",AddProblemActivity.class);
        solo.clickOnButton("back");
        solo.assertCurrentActivity("should be ProblemListActivity", ProblemListActivity.class);
    }
}
