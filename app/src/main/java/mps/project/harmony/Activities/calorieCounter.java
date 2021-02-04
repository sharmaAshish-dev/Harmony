package mps.project.harmony.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mps.project.harmony.R;

public class calorieCounter extends AppCompatActivity {

    private com.warkiz.widget.IndicatorSeekBar userAge, userWeight, userHeight;

    private ImageView increaseAge, decreaseAge;
    private ImageView increaseWeight, decreaseWeight;
    private ImageView increaseHeight, decreaseHeight;

    private RelativeLayout calculateBtn;
    private TextView maleCheckBox, femaleCheckBox;

    private TextView caloriesIntake;

    private Boolean maleSelected = true;
    private Boolean femaleSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_counter);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        caloriesIntake = findViewById(R.id.caloriesIntake);

        userAge = findViewById(R.id.age);
        userWeight = findViewById(R.id.weightBar);
        userHeight = findViewById(R.id.heightSeeker);

        maleCheckBox = findViewById(R.id.maleCheckBox);
        femaleCheckBox = findViewById(R.id.femaleCheckBox);

        increaseAge = findViewById(R.id.addAge);
        decreaseAge = findViewById(R.id.subtractAge);

        increaseWeight = findViewById(R.id.addWeight);
        decreaseWeight = findViewById(R.id.subtractWeight);

        increaseHeight = findViewById(R.id.addHeight);
        decreaseHeight = findViewById(R.id.subtractHeight);

        calculateBtn = findViewById(R.id.calculateProteinBtn);

        maleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleCheckBox.setBackgroundResource(R.drawable.checkbox_selected_state);
                femaleCheckBox.setBackgroundResource(R.drawable.checkbox_normal_state);

                maleCheckBox.setTextColor(getResources().getColor(R.color.logoColorWhite));
                femaleCheckBox.setTextColor(getResources().getColor(R.color.logoColorBlack));

                maleSelected = true;
                femaleSelected = false;

            }
        });

        femaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femaleCheckBox.setBackgroundResource(R.drawable.checkbox_selected_state);
                maleCheckBox.setBackgroundResource(R.drawable.checkbox_normal_state);

                femaleCheckBox.setTextColor(getResources().getColor(R.color.logoColorWhite));
                maleCheckBox.setTextColor(getResources().getColor(R.color.logoColorBlack));

                maleSelected = false;
                femaleSelected = true;
            }
        });

        increaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userAge.getProgressFloat() < 100) {
                    userAge.setProgress(userWeight.getProgressFloat() + 1f);
                }
            }
        });

        decreaseAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userAge.getProgressFloat() > 1) {
                    userAge.setProgress(userWeight.getProgressFloat() - 1f);
                }
            }
        });

        increaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userWeight.getProgressFloat() < 180) {
                    userWeight.setProgress(userWeight.getProgressFloat() + 0.1f);
                }
            }
        });

        decreaseWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userWeight.getProgressFloat() > 1) {
                    userWeight.setProgress(userWeight.getProgressFloat() - 0.1f);
                }
            }
        });

        increaseHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHeight.getProgressFloat() < 220) {
                    userHeight.setProgress(userHeight.getProgressFloat() + 1f);
                }
            }
        });

        decreaseHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHeight.getProgressFloat() > 1) {
                    userHeight.setProgress(userHeight.getProgressFloat() - 1f);
                }
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                BMR (kcal / day) = 10 x weight (kg) + 6.25 x height (cm) – 5 x age (y) – 161 (kcal / day)

                Double Calories = 0.0;

                if (maleSelected) {

                    Calories = 10 * userWeight.getProgressFloat() + 6.25 * userHeight.getProgressFloat() - 5 * userAge.getProgressFloat() + 5;

                }

                if (femaleSelected) {

                    Calories = 10 * userWeight.getProgressFloat() + 6.25 * userHeight.getProgressFloat() - 5 * userAge.getProgressFloat() - 161;

                }

                caloriesIntake.setText(String.valueOf(Calories));

                editor.putString("calories", String.valueOf(Calories));
                editor.apply();

            }
        });

    }
}