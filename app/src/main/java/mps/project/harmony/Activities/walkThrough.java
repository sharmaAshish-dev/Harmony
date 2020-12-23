package mps.project.harmony.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import mps.project.harmony.Adapters.ScreenSlidePagerAdapter;
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