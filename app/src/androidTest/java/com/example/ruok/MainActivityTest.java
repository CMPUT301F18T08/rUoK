package com.example.ruok;
import android.app.Activity;
import com.example.ruok.activities.MainActivity;
import com.example.ruok.activities.ProblemListActivity;
import com.example.ruok.activities.SignUpActivity;
import com.robotium.solo.Solo;

import android.support.test.rule.ActivityTestRule;
import android.widget.EditText;

import org.junit.Test;

import classes.CareProvider;
import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.InstrumentationRegistry.getInstrumentation;
/* created by Yuhan Ye*/
public class MainActivityTest extends ActivityInstrumentationTestCase2{
    private Solo solo;
    private CareProvider yyh = new CareProvider();


    public MainActivityTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(),getActivity());
    }

    public void testStart() throws Exception{
        Activity activity = getActivity();
    }
    @Test
    public void testSignUp() throws Exception{
        MainActivity activity = (MainActivity) solo.getCurrentActivity();
        solo.assertCurrentActivity("should be MainActivity",MainActivity.class);
        solo.clickOnButton("sign up");
        solo.assertCurrentActivity("should be SignUpActivity", SignUpActivity.class);
    }
//    @Test
//    public void testCareproviderSignIn() throws Exception{
//        MainActivity activity = (MainActivity) solo.getCurrentActivity();
//        solo.assertCurrentActivity("should be MainActivity",MainActivity.class);
//        solo.enterText((EditText)solo.getView(R.id.userName),"yyh");
//        solo.enterText((EditText)solo.getView(R.id.password),"qwerty");
//        solo.clickOnButton(R.id.SignIn);
//        solo.assertCurrentActivity("should be CareProviderActivity", CareProvider.class);
//    }
//    @Test
//    public void testPatientSignIn() throws Exception{
//        MainActivity activity = (MainActivity) solo.getCurrentActivity();
//        solo.assertCurrentActivity("should be MainActivity",MainActivity.class);
//        solo.enterText((EditText)solo.getView(R.id.userName),"shiki");
//        solo.enterText((EditText)solo.getView(R.id.password),"qwerty");
//        solo.clickOnButton("SIGN IN");
//        solo.assertCurrentActivity("should be ProblemListActivity", ProblemListActivity.class);
//    }


}
