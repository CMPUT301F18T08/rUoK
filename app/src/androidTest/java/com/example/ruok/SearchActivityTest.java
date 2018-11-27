package com.example.ruok;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;



import com.example.ruok.Activities.SearchActivity;
import com.example.ruok.Activities.CareProviderActivity;

import com.robotium.solo.Solo;

import org.junit.Test;

public class SearchActivityTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;

    public SearchActivityTest() {
        super(SearchActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSave() throws Exception{
        SearchActivity activity = (SearchActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be SearchActivity",SearchActivity.class);
        solo.clickOnButton("search");
        solo.assertCurrentActivity("should be CareProviderActivity", CareProviderActivity.class);
    }
}
