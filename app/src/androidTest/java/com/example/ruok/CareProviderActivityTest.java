package com.example.ruok;
import android.app.Activity;

import com.example.ruok.Activities.AddPatientActivity;
import com.example.ruok.Activities.CareProviderActivity;
import com.example.ruok.Activities.ResetPasswordActivity;
import com.example.ruok.Activities.SearchActivity;
import com.robotium.solo.Solo;


import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

/* created by Yuhan Ye*/
public class CareProviderActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public CareProviderActivityTest() {
        super(CareProviderActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testAddPatient() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("add a patient");
        solo.assertCurrentActivity("should be AddPatientActivity", AddPatientActivity.class);
    }
    @Test
    public void testSearch() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("search");
        solo.assertCurrentActivity("should be SearchActivity", SearchActivity.class);
    }
    @Test
    public void resetPassword() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("reset password");
        solo.assertCurrentActivity("should be ResetPasswordActivity", ResetPasswordActivity.class);
    }
}
