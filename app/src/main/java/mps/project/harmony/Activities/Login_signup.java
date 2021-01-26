package mps.project.harmony.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import mps.project.harmony.Adapters.loginSignUpSwitchAdapter;
import mps.project.harmony.R;

public class Login_signup extends AppCompatActivity {

    private ViewPager viewPager;
    private loginSignUpSwitchAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        viewPager = findViewById(R.id.sliderPager);
        viewPager.setOffscreenPageLimit(1);

        pagerAdapter = new loginSignUpSwitchAdapter(getSupportFragmentManager());

        viewPager.setAdapter(pagerAdapter);
    }
}