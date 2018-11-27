package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.Activities.RecordDetailActivity;
import com.example.ruok.Activities.RecordPageActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class RecordDetailActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public RecordDetailActivityTest() {
        super(RecordDetailActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testback() throws Exception{
        RecordDetailActivity activity = (RecordDetailActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be RecordDetailActivity",RecordDetailActivity.class);
        solo.clickOnButton("back");
        solo.assertCurrentActivity("should be RecordPageActivity", RecordPageActivity.class);
    }
}
