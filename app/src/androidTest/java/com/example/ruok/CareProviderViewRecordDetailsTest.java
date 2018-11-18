
package com.example.ruok;
import android.app.Activity;

import com.example.ruok.activities.AddPatientActivity;
import com.example.ruok.activities.CareProviderActivity;
import com.example.ruok.activities.CareProviderViewListOfRecordsActivity;
import com.example.ruok.activities.CareProviderViewRecordDetailsActivity;
import com.example.ruok.activities.ResetPasswordActivity;
import com.example.ruok.activities.SearchActivity;
import com.robotium.solo.Solo;

import android.support.test.rule.ActivityTestRule;

import org.junit.Test;

import classes.CareProvider;

import static android.support.test.InstrumentationRegistry.getInstrumentation;

/* created by Yuhan Ye*/
public class CareProviderViewRecordDetailsTest extends ActivityTestRule {
    private Solo solo;
    private CareProvider yyh = new CareProvider();

    public CareProviderViewRecordDetailsTest() {
        super(CareProviderViewRecordDetailsActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }

    @Test
    public void testBack() throws Exception{
        CareProviderViewRecordDetailsActivity activity = (CareProviderViewRecordDetailsActivity)solo.getCurrentActivity();
        solo.assertCurrentActivity("should be CareProviderViewRecordDetailsActivity",CareProviderViewRecordDetailsActivity.class);
        solo.clickOnButton("BACK");
        solo.assertCurrentActivity("should be CareProviderViewListOfRecordsActivity", CareProviderViewListOfRecordsActivity.class);
    }
}
