package com.example.ruok;
import android.app.Activity;

import com.example.ruok.activities.CareProviderViewListOfRecordsActivity;
import com.example.ruok.activities.GeolocationActivity;
import com.example.ruok.activities.ShowPopupCommentActivity;
import com.robotium.solo.Solo;


import android.test.ActivityInstrumentationTestCase2;

import org.junit.Test;

public class CareProviderViewListOfRecordsActivityTest extends ActivityInstrumentationTestCase2{
    private Solo solo;

    public CareProviderViewListOfRecordsActivityTest() {
        super(CareProviderViewListOfRecordsActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testViewGeolocation() throws Exception{
        CareProviderViewListOfRecordsActivity activity = (CareProviderViewListOfRecordsActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderViewListOfRecordsActivity",CareProviderViewListOfRecordsActivity.class);
        solo.clickOnButton("view geolocation");
        solo.assertCurrentActivity("should be GeolocationActivity", GeolocationActivity.class);
    }
    @Test
    public void testAddComment()throws Exception{
        CareProviderViewListOfRecordsActivity activity = (CareProviderViewListOfRecordsActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderViewListOfRecordsActivity",CareProviderViewListOfRecordsActivity.class);
        solo.clickOnButton("add a comment");
        solo.assertCurrentActivity("should be ShowPopupCommentActivity", ShowPopupCommentActivity.class);

    }
}
