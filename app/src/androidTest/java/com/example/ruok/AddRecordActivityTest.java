package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.Activities.AddRecordActivity;
import com.example.ruok.Activities.RecordPageActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class AddRecordActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public AddRecordActivityTest() {
        super(AddRecordActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        AddRecordActivity activity = (AddRecordActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be AddRecordActivity",AddRecordActivity.class);
        solo.clickOnButton("save");
        solo.assertCurrentActivity("should be RecordPageActivity", RecordPageActivity.class);
    }
}
