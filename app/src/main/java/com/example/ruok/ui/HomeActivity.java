package com.example.ruok.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.ruok.R;
import com.example.ruok.ui.fragment.MeFragment;
import com.example.ruok.ui.fragment.PatientListFragment;
import com.example.ruok.ui.fragment.ProblemFragment;
import com.example.ruok.utils.SpUtil;

/**
 * Common Home Page of Patient  and CareProvider
 * If current userType is patient ，show ProblemFragment，otherwise show PatientListFragment
 */
public class HomeActivity extends AppCompatActivity {
    private Fragment[] fragments;
    private int index;
    private int currentIndex;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_problem:
                    index = 0;
                    //set navigation，if user is patient，set to problem；if user is CareProvider then set to Patient
                    String userType = SpUtil.getCurrentUser().getUserType();
                    if ("patient".equals(userType)) {
                        item.setTitle("Problem List");
                    } else {
                        item.setTitle("Patient List");
                    }
                    break;
                case R.id.navigation_me:
                    index = 1;
                    break;
            }

            showFragment(index);
            return true;
        }
    };

    /**
     * 切换fragment
     *
     * @param index：0-2
     */
    public void showFragment(int index) {
        if (currentIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fl_main, fragments[index]);
            }
            trx.show(fragments[index]).commit();
        }

        currentIndex = index;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //default set to the first item，to trigger mOnNavigationItemSelectedListener event，then set the navigation based on UserType
        navigation.setSelectedItemId(R.id.navigation_problem);

        //根据不同的身份添加不同的页面
        if (SpUtil.getCurrentUser().getUserType().equals("patient")) {
            fragments = new Fragment[]{new ProblemFragment(), new MeFragment()};
        } else {
            fragments = new Fragment[]{new PatientListFragment(), new MeFragment()};
        }
        getSupportFragmentManager().beginTransaction().add(R.id.fl_main, fragments[0]).show(fragments[0]).commit();

    }


}
