package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.Activities.AddPatientActivity;
import com.example.ruok.Activities.CareProviderActivity;
import com.robotium.solo.Solo;

import org.junit.Test;

public class AddPatientActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public AddPatientActivityTest() {
        super(AddPatientActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        AddPatientActivity activity = (AddPatientActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be AddPatientActivity",AddPatientActivity.class);
        solo.clickOnButton("save");
        solo.assertCurrentActivity("should be CareProviderActivity", CareProviderActivity.class);
    }
}
