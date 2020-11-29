package mps.project.harmony.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import mps.project.harmony.Fragments.dashboard;
import mps.project.harmony.Fragments.profile;
import mps.project.harmony.Fragments.settings;
import mps.project.harmony.R;

public class homeScreen extends AppCompatActivity {

    ChipNavigationBar buttomNavBar;
    FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        buttomNavBar = findViewById(R.id.bottom_nav);

        if (savedInstanceState == null) {
            buttomNavBar.setItemSelected(R.id.dashboard, true);
            fragmentManager = getSupportFragmentManager();
            dashboard dashboardFragment = new dashboard();
            fragmentManager.beginTransaction()
                    .replace(R.id.fragContainer, dashboardFragment)
                    .commit();

        }

        buttomNavBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            private final String TAG = homeScreen.class.getSimpleName();

            @Override
            public void onItemSelected(int id) {
                Fragment fragment;
                switch (id) {
                    case R.id.dashboard:
                        fragment = new dashboard();
                        break;
                    case R.id.profile:
                        fragment = new profile();
                        break;
                    case R.id.settings:
                        fragment = new settings();
                        break;
                    default:
                        fragment = new dashboard();
                        break;
                }

                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragContainer, fragment)
                        .commit();

            }
        });
    }
}