package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.example.ruok.activities.BodyLocationActivity;
import com.example.ruok.activities.ViewBodyLocationPhotosActivity;
import com.example.ruok.activities.CareProviderActivity;
import com.example.ruok.activities.ProblemListActivity;
import com.robotium.solo.Solo;

import org.junit.Test;

public class BodyLocationActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public BodyLocationActivityTest() {
        super(BodyLocationActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        BodyLocationActivity activity = (BodyLocationActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be BodyLocationActivity",BodyLocationActivity.class);
        solo.clickOnButton("savePhoto");
        solo.assertCurrentActivity("should be ViewBodyLocationPhotosActivity", ViewBodyLocationPhotosActivity.class);
    }
    public void testDelete() throws Exception{
        BodyLocationActivity activity = (BodyLocationActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be BodyLocationActivity",BodyLocationActivity.class);
        solo.clickOnButton("Delete");
        solo.assertCurrentActivity("should be ViewBodyLocationPhotosActivity", ViewBodyLocationPhotosActivity.class);
    }
    public void testBack() throws Exception{
        BodyLocationActivity activity = (BodyLocationActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be BodyLocationActivity",BodyLocationActivity.class);
        solo.clickOnButton("BACK");
        solo.assertCurrentActivity("should be ViewBodyLocationPhotosActivity", ViewBodyLocationPhotosActivity.class);
    }
}
