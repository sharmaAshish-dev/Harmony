package mps.project.harmony.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import mps.project.harmony.R;

public class bmiCalculator extends AppCompatActivity {

    private com.warkiz.widget.IndicatorSeekBar userHeight, userWeight;
    private ImageView increaseHeight, decreaseHeight;
    private ImageView increaseWeight, decreaseWeight;
    private TextView bmiScore, bmiScoreRemark;
    private CardView calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_calculator);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        userHeight = findViewById(R.id.heightSeeker);
        userWeight = findViewById(R.id.weightBar);

        increaseHeight = findViewById(R.id.addHeight);
        decreaseHeight = findViewById(R.id.subtractHeight);

        increaseWeight = findViewById(R.id.addWeight);
        decreaseWeight = findViewById(R.id.subtractWeight);

        bmiScore = findViewById(R.id.proteinIntake);
        bmiScoreRemark = findViewById(R.id.txtRemark);

        calculateBtn = findViewById(R.id.calculateProteinBtn);

        increaseHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHeight.getProgressFloat() < 180) {
                    userHeight.setProgress(userHeight.getProgressFloat() + 0.1f);
                }
            }
        });

        decreaseHeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userHeight.getProgressFloat() > 1) {
                    userHeight.setProgress(userHeight.getProgressFloat() - 0.1f);
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

//        Body Mass Index (BMI) = (weight (kg) / height (m2) / height (m2)
//        Example: Your weight = 68 kg / Your height = 1.65 m (165 cm)
//        BMI Calculation: 68 ÷ 1.652 ÷ 1.652 = 24.98

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double heightInMetre = userHeight.getProgressFloat() / 100;
                int bmiNumber = (int) (userWeight.getProgressFloat() / heightInMetre / heightInMetre);
                bmiScore.setText(String.valueOf(bmiNumber));

                editor.putString("bmi", String.valueOf(bmiNumber));
                editor.apply();

                if (bmiNumber > 0 && bmiNumber <= 16) {
                    bmiScoreRemark.setText("Severely Underweight");
                } else if (bmiNumber > 16 && bmiNumber <= 18.5) {
                    bmiScoreRemark.setText("Underweight");
                } else if (bmiNumber > 18.5 && bmiNumber <= 25) {
                    bmiScoreRemark.setText("Normal");
                } else if (bmiNumber > 25 && bmiNumber <= 30) {
                    bmiScoreRemark.setText("Overweight");
                } else if (bmiNumber > 30) {
                    bmiScoreRemark.setText("OBESE CLASS");
                }

            }
        });
    }
}