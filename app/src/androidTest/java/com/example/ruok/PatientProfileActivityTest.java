package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.Activities.PatientProfileActivity;
import com.example.ruok.Activities.ProblemListActivity;
import com.robotium.solo.Solo;

import org.junit.Test;

public class PatientProfileActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public PatientProfileActivityTest() {
        super(PatientProfileActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        PatientProfileActivity activity = (PatientProfileActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be PatientProfileActivity",PatientProfileActivity.class);
        solo.clickOnButton("save");
        solo.assertCurrentActivity("should be ProblemListActivity", ProblemListActivity.class);
    }
}
