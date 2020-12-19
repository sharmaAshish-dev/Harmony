package mps.project.harmony.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import mps.project.harmony.R;

public class proteinCalculator extends AppCompatActivity {

    private com.warkiz.widget.IndicatorSeekBar userWeight;
    private ImageView increaseWeight, decreaseWeight;
    private CardView calculateBtn;
    private RadioButton ft1, ft2, ft3, ft4, ft5;
    private double userFitnessLevel = 0;
    private TextView proteinRequired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_protein_calculator);

        userWeight = findViewById(R.id.weightBar);

        ft1 = findViewById(R.id.radioBtn1);
        ft2 = findViewById(R.id.radioBtn2);
        ft3 = findViewById(R.id.radioBtn3);
        ft4 = findViewById(R.id.radioBtn4);
        ft5 = findViewById(R.id.radioBtn5);

        increaseWeight = findViewById(R.id.addWeight);
        decreaseWeight = findViewById(R.id.subtractWeight);

        calculateBtn = findViewById(R.id.calculateProteinBtn);
        proteinRequired = findViewById(R.id.proteinIntake);

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

            }
        });

    }
}