package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.Activities.ShowPopupCommentActivity;
import com.example.ruok.Activities.CareProviderViewListOfRecordsActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class ShowPopupCommentActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public ShowPopupCommentActivityTest() {
        super(ShowPopupCommentActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testback() throws Exception{
        ShowPopupCommentActivity activity = (ShowPopupCommentActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be ShowPopupCommentActivity",ShowPopupCommentActivity.class);
        solo.clickOnButton("back");
        solo.assertCurrentActivity("should be CareProviderViewListOfRecordsActivity", CareProviderViewListOfRecordsActivity.class);
    }
}
