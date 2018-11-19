package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.activities.FrontAndBackPhotoActivity;
import com.example.ruok.activities.AddPhotoActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class FrontAndBackPhotoActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public FrontAndBackPhotoActivityTest() {
        super(FrontAndBackPhotoActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testaddphoto() throws Exception{
        FrontAndBackPhotoActivity activity = (FrontAndBackPhotoActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be FrontAndBackPhotoActivity",FrontAndBackPhotoActivity.class);
        solo.clickOnButton("add a photo");
        solo.assertCurrentActivity("should be AddPhotoActivity", AddPhotoActivity.class);
    }
    

}
