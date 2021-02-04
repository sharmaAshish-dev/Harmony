package mps.project.harmony.Activities;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import mps.project.harmony.R;

public class drinkWater extends AppCompatActivity {

    private TextView remainingWater;
    private EditText targetWater;
    private ImageView addWaterBtn;
    private int rWater;
    private int goal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_water);

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        remainingWater = findViewById(R.id.remainingWater);
        targetWater = findViewById(R.id.targetWater);
        addWaterBtn = findViewById(R.id.addWaterBtn);

        rWater = Integer.parseInt(remainingWater.getText().toString());

        if (targetWater.getText().toString().equals("")) {
            goal = Integer.parseInt(targetWater.getHint().toString());
        } else {
            goal = Integer.parseInt(targetWater.getText().toString());
        }

        addWaterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (rWater < goal || goal != 0) {
                    remainingWater.setText(String.valueOf(rWater + 270));
                } else {
                    Toast.makeText(drinkWater.this, "Increase Target water amount.", Toast.LENGTH_SHORT).show();
                }

                editor.putString("water", String.valueOf(rWater + 270));
                editor.apply();

            }
        });

    }
}