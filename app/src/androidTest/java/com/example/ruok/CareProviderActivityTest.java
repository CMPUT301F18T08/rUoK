package com.example.ruok;
import android.app.Activity;

import com.example.ruok.activities.CareProviderActivity;
import com.example.ruok.activities.ResetPasswordActivity;
import com.example.ruok.activities.SearchActivity;
import com.robotium.solo.Solo;

import android.support.test.rule.ActivityTestRule;
import classes.CareProvider;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/* created by Yuhan Ye*/
public class CareProviderActivityTest extends ActivityTestRule{
    private Solo solo;
    private CareProvider yyh = new CareProvider();

    public CareProviderActivityTest() {
        super(CareProviderActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }

    public void testAddPatient() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("ADD A PATIENT");
//        solo.assertCurrentActivity();
    }
    public void testSearch() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("SEARCH");
        solo.assertCurrentActivity("should be SearchActivity", SearchActivity.class);
    }
    public void resetPassword() throws Exception{
        CareProviderActivity activity = (CareProviderActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderActivity",CareProviderActivity.class);
        solo.clickOnButton("RESET PASSWORD");
        solo.assertCurrentActivity("should be ResetPasswordActivity", ResetPasswordActivity.class);
    }
}
