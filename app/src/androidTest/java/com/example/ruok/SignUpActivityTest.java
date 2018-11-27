package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.Activities.SignUpActivity;
import com.example.ruok.Activities.MainActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class SignUpActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public SignUpActivityTest() {
        super(SignUpActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testsave() throws Exception{
        SignUpActivity activity = (SignUpActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be SignUpActivity",SignUpActivity.class);
        
        solo.clickOnButton("save");
        solo.assertCurrentActivity("should be MainActivity", MainActivity.class);

    }
    public void testback() throws Exception{
        SignUpActivity activity = (SignUpActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be SignUpActivity",SignUpActivity.class);
        
        solo.clickOnButton("back");
        solo.assertCurrentActivity("should be MainActivity", MainActivity.class);

    }
}
