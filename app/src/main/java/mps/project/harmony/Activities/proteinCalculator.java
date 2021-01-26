package mps.project.harmony.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mps.project.harmony.R;

public class proteinCalculator extends AppCompatActivity {

    private com.warkiz.widget.IndicatorSeekBar userWeight;
    private ImageView increaseWeight, decreaseWeight;
    private RelativeLayout calculateBtn;
    private RadioButton ft1, ft2, ft3, ft4, ft5;
    private double userFitnessLevel = 0;
    private TextView proteinRequired;
    private TextView maleCheckBox, femaleCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_calculator);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        userWeight = findViewById(R.id.weightBar);

        ft1 = findViewById(R.id.radioBtn1);
        ft2 = findViewById(R.id.radioBtn2);
        ft3 = findViewById(R.id.radioBtn3);
        ft4 = findViewById(R.id.radioBtn4);
        ft5 = findViewById(R.id.radioBtn5);

        maleCheckBox = findViewById(R.id.maleCheckBox);
        femaleCheckBox = findViewById(R.id.femaleCheckBox);

        increaseWeight = findViewById(R.id.addWeight);
        decreaseWeight = findViewById(R.id.subtractWeight);

        calculateBtn = findViewById(R.id.calculateProteinBtn);
        proteinRequired = findViewById(R.id.proteinIntake);

        maleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                maleCheckBox.setBackgroundResource(R.drawable.checkbox_selected_state);
                femaleCheckBox.setBackgroundResource(R.drawable.checkbox_normal_state);

                maleCheckBox.setTextColor(getResources().getColor(R.color.logoColorWhite));
                femaleCheckBox.setTextColor(getResources().getColor(R.color.logoColorBlack));

            }
        });

        femaleCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                femaleCheckBox.setBackgroundResource(R.drawable.checkbox_selected_state);
                maleCheckBox.setBackgroundResource(R.drawable.checkbox_normal_state);

                femaleCheckBox.setTextColor(getResources().getColor(R.color.logoColorWhite));
                maleCheckBox.setTextColor(getResources().getColor(R.color.logoColorBlack));
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

        ft1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFitnessLevel = 1.2;
            }
        });

        ft2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFitnessLevel = 1.375;

            }
        });

        ft3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFitnessLevel = 1.465;

            }
        });

        ft4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFitnessLevel = 1.55;

            }
        });

        ft5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userFitnessLevel = 1.725;
            }
        });

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proteinAmount = String.valueOf((int) (userFitnessLevel * userWeight.getProgressFloat()));
                proteinRequired.setText(proteinAmount);

                editor.putString("protein", proteinAmount);
                editor.apply();

            }
        });

    }
}