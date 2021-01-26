package mps.project.harmony.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mps.project.harmony.R;

public class splash extends AppCompatActivity {

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_TIME_OUT = 3000;

        FirebaseUser currentUser = mAuth.getCurrentUser();

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
                // Check if user is signed in (non-null) and update UI accordingly.

                if (currentUser == null) {
                    Intent dashBoardIntent = new Intent(splash.this, walkThrough.class);

                    startActivity(dashBoardIntent);

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    // closing the activity
                    finish();
                } else {
                    Intent dashBoardIntent = new Intent(splash.this, homeScreen.class);

                    startActivity(dashBoardIntent);

                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

                    // closing the activity
                    finish();
                }

            }
        }, SPLASH_TIME_OUT);        // SPLASH_TIME_OUT = 3 Sec;
    }
}