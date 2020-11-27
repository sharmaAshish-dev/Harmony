package mps.project.harmony.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import mps.project.harmony.Adapters.ScreenSlidePagerAdapter;
import mps.project.harmony.Fragments.walkThrough1;
import mps.project.harmony.Fragments.walkThrough2;
import mps.project.harmony.Fragments.walkThrough3;
import mps.project.harmony.R;

public class walkThrough extends AppCompatActivity {

    private ViewPager viewPager;
    private ScreenSlidePagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);

        viewPager = findViewById(R.id.sliderPager);

        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
    }


}