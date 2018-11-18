package com.example.ruok;
import android.app.Activity;

import com.example.ruok.activities.AddPatientActivity;
import com.example.ruok.activities.CareProviderActivity;
import com.example.ruok.activities.MainActivity;
import com.example.ruok.activities.ResetPasswordActivity;
import com.example.ruok.activities.SearchActivity;
import com.example.ruok.activities.SignUpActivity;
import com.robotium.solo.Solo;

import android.support.test.rule.ActivityTestRule;

import org.junit.Test;

import classes.CareProvider;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/* created by Yuhan Ye*/
public class SignUpActivityTest extends ActivityTestRule{
    private Solo solo;
    private CareProvider yyh = new CareProvider();

    public SignUpActivityTest() {
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
        SignUpActivity activity = (SignUpActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be SignUpActivity",SignUpActivity.class);
        solo.clickOnButton("save");
        solo.assertCurrentActivity("should be MainActivity", MainActivity.class);
    }
}
