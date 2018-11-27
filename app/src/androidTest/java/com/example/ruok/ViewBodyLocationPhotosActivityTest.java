package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.Activities.AddPhotoActivity;
import com.example.ruok.Activities.ViewBodyLocationPhotosActivity;
import com.robotium.solo.Solo;

import org.junit.Test;

public class ViewBodyLocationPhotosActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public ViewBodyLocationPhotosActivityTest() {
        super(ViewBodyLocationPhotosActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testaddPhoto() throws Exception{
        ViewBodyLocationPhotosActivity activity = (ViewBodyLocationPhotosActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be ViewBodyLocationPhotosActivity",ViewBodyLocationPhotosActivity.class);
        solo.clickOnButton("addPhoto");
        solo.assertCurrentActivity("should be AddPhotoActivity", AddPhotoActivity.class);
    }
    
}
