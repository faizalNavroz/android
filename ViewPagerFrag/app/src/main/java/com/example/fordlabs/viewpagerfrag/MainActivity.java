package com.example.fordlabs.viewpagerfrag;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment>fragments = getFragments();
        ViewPager viewPager = findViewById(R.id.viewpager);
        myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager.setAdapter(myPagerAdapter);
    }



        private List<Fragment> getFragments(){

            List<Fragment> fList = new ArrayList<Fragment>();
            fList.add(MyFragment.newInstance("Fragment 1"));

            fList.add(MyFragment.newInstance("Fragment 2"));

            fList.add(MyFragment.newInstance("Fragment 3"));
            return fList;

        }
}
