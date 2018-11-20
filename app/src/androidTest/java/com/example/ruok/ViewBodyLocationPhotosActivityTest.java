package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.activities.AddPhotoActivity;
import com.example.ruok.activities.ViewBodyLocationPhotosActivity;
import com.example.ruok.activities.BodyLocationActivity;
import com.example.ruok.activities.ProblemListActivity;
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
        solo.clickOnButton("addphoto");
        solo.assertCurrentActivity("should be AddPhotoActivity", AddPhotoActivity.class);
    }
    public void testBrowse() throws Exception{
        ViewBodyLocationPhotosActivity activity = (ViewBodyLocationPhotosActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be ViewBodyLocationPhotosActivity",ViewBodyLocationPhotosActivity.class);
        solo.clickOnButton("browse photo");
        solo.assertCurrentActivity("should be BodyLocationActivity", BodyLocationActivity.class);
    }
    
}
