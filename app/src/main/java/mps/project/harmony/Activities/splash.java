package mps.project.harmony.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;

import mps.project.harmony.MainActivity;
import mps.project.harmony.R;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 3000;

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                //Intent i = new Intent(splash.this, MainActivity.class);

//                 If User is already logged in them navigating them directly to Main Dashboard Page

                // else navigating them to Login Page

                    Intent dashBoardIntent = new Intent(splash.this, MainActivity.class);
                    // Starting the next Activity
//                    Pair[] pairs = new Pair[2];
//
//                    pairs[0] = new Pair<View,String>(appLogo,"splashAnimation");
//                    pairs[1] = new Pair<View,String>(view,"backTint");
//                    pairs[2] = new Pair<View,String>(userName,"ContactTransition");

//                    ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(splash.this, pairs);
//                    startActivity(i,options.toBundle());

                startActivity(dashBoardIntent);

                // closing the activity
                finish();
            }
        }, SPLASH_TIME_OUT);        // SPLASH_TIME_OUT = 3 Sec;
    }
}