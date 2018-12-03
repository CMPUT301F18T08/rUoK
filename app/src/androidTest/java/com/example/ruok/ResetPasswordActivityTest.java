package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.activities.ResetPasswordActivity;
import com.example.ruok.activities.MainActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

//public class ResetPasswordActivityTest extends ActivityInstrumentationTestCase2 {
//    private Solo solo;
//
//    public ResetPasswordActivityTest() {
//        super(ResetPasswordActivity.class);
//    }
//
//    public void setUp() throws Exception{
//        solo = new Solo(getInstrumentation(),getActivity());
//    }
//
//    public void testStart() throws Exception{
//        Activity activity = getActivity();
//    }
//    @Test
//    public void testSave() throws Exception{
//        ResetPasswordActivity  activity = (ResetPasswordActivity ) solo.getCurrentActivity();
//        solo.assertCurrentActivity("should be ResetPasswordActivity ",ResetPasswordActivity .class);
//        solo.clickOnButton("save");
//        solo.assertCurrentActivity("should be MainActivity", MainActivity.class);
//    }
//}
