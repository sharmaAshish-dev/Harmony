package mps.project.harmony.Activities;

import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import mps.project.harmony.R;
import mps.project.harmony.pedoMeterModule.StepDetector;
import mps.project.harmony.pedoMeterModule.StepListener;

public class pedoMeter extends AppCompatActivity implements SensorEventListener, StepListener {

    private TextView TvSteps;
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private int numSteps;
    private Button BtnStart, BtnStop;
    private CardView startPedometerBtn, stopPedometerBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedo_meter);

        // Get an instance of the SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);

        TvSteps = findViewById(R.id.steps);
        BtnStart = findViewById(R.id.btn_start);
        BtnStop = findViewById(R.id.btn_stop);
        startPedometerBtn = findViewById(R.id.startPedometerBtn);
        stopPedometerBtn = findViewById(R.id.stopPedometerBtn);

        startPedometerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                numSteps = 0;
                sensorManager.registerListener(pedoMeter.this, accel, SensorManager.SENSOR_DELAY_FASTEST);

            }
        });


        stopPedometerBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                sensorManager.unregisterListener(pedoMeter.this);

            }
        });

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void step(long timeNs) {
        numSteps++;
//        0.04 calories per step.
        TvSteps.setText(numSteps);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("walk", TvSteps.getText().toString());
        editor.apply();

    }
}