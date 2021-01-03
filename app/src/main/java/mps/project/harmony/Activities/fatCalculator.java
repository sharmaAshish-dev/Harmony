package mps.project.harmony.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mps.project.harmony.R;

import static java.lang.Math.log10;

public class fatCalculator extends AppCompatActivity {

    private com.warkiz.widget.IndicatorSeekBar userAge, userWeight, userHeight, userAbdomen, userHip, userNeck;

    private ImageView increaseAge, decreaseAge;
    private ImageView increaseWeight, decreaseWeight;
    private ImageView increaseHeight, decreaseHeight;
    private ImageView increaseAbdomen, decreaseAbdomen;
    private ImageView increaseHip, decreaseHip;
    private ImageView increaseNeck, decreaseNeck;

    private RelativeLayout calculateBtn;

    private TextView maleCheckBox, femaleCheckBox;

    private Boolean maleSelected = false;
    private Boolean femaleSelected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fat_calculator);


        userAge = findViewById(R.id.age);
        userWeight = findViewById(R.id.weightBar);
        userHeight = findViewById(R.id.heightSeeker);
        userAbdomen = findViewById(R.id.abdomenSeeker);
        userHip = findViewById(R.id.HipSeeker);
        userNeck = findViewById(R.id.NeckSeeker);

        maleCheckBox = findViewById(R.id.maleCheckBox);
        femaleCheckBox = findViewById(R.id.femaleCheckBox);

        increaseAge = findViewById(R.id.addAge);
        decreaseAge = findViewById(R.id.subtractAge);

        increaseWeight = findViewById(R.id.addWeight);
        decreaseWeight = findViewById(R.id.subtractWeight);

        increaseHeight = findViewById(R.id.addHeight);
        decreaseHeight = findViewById(R.id.subtractHeight);

        increaseAbdomen = findViewById(R.id.addabdomen);
        decreaseAbdomen = findViewById(R.id.subtractabdomen);

        increaseHip = findViewById(R.id.addHip);
        decreaseHip = findViewById(R.id.subtractHip);

        increaseNeck = findViewById(R.id.addNeck);
        decreaseNeck = findViewById(R.id.subtractNeck);

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

        increaseAbdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userAbdomen.getProgressFloat() < 143) {
                    userAbdomen.setProgress(userAbdomen.getProgressFloat() + 1f);
                }
            }
        });

        decreaseAbdomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userAbdomen.getProgressFloat() > 1) {
                    userAbdomen.setProgress(userAbdomen.getProgressFloat() - 1f);
                }
            }
        });

        increaseHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHip.getProgressFloat() < 143) {
                    userHip.setProgress(userHip.getProgressFloat() + 1f);
                }
            }
        });

        decreaseHip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHip.getProgressFloat() > 1) {
                    userHip.setProgress(userHip.getProgressFloat() - 1f);
                }
            }
        });

        increaseNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNeck.getProgressFloat() < 100) {
                    userNeck.setProgress(userNeck.getProgressFloat() + 1f);
                }
            }
        });

        decreaseNeck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNeck.getProgressFloat() > 1) {
                    userNeck.setProgress(userNeck.getProgressFloat() - 1f);
                }
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Body fat percentage (BFP) formula for males:
//                USC Units:  BFP = 86.010×log10(abdomen-neck) - 70.041×log10(height) + 36.76

//                SI, Metric Units: BFP = 495 / 1.0324 - 0.19077×log10(waist-neck) ) + 0.15456×log10(height) - 450
//
//                Body fat percentage (BFP) formula for females:
//                USC Units:  BFP = 163.205×log10(waist+hip-neck) - 97.684×(log10(height)) + 36.76
//                SI, Metric Units: BFP = 495 / 1.29579 - 0.35004×log10(waist+hip-neck) + 0.22100×log10(height) - 450
//
//                Fat mass (FM) formula:
//
//                FM = BF × Weight
//
//                Lean Mass (LM) formula:
//
//                LM = Weight - FM

                Double BFP, fatMass, leanMass;

                if (maleSelected) {
                    BFP = ((495 / (1.0324 + (-0.19077 * log10(userAbdomen.getProgressFloat() - userNeck.getProgressFloat()))) + (0.15456 * log10(userHeight.getProgressFloat())))) - 450;

                    fatMass = BFP * userWeight.getProgressFloat();

                    leanMass = userWeight.getProgressFloat() - fatMass;

                }

                if (femaleSelected) {

                    BFP = ((495 / (1.29579 + (-0.35004 * log10(userAbdomen.getProgressFloat() + userHip.getProgressFloat() - userNeck.getProgressFloat()))) + (0.22100 * log10(userHeight.getProgressFloat())))) - 450;

                    fatMass = BFP * userWeight.getProgressFloat();

                    leanMass = userWeight.getProgressFloat() - fatMass;

                }


            }
        });

    }

}