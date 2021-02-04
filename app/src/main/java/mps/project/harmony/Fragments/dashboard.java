package mps.project.harmony.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import mps.project.harmony.Activities.HeartMeter;
import mps.project.harmony.Activities.fatCalculator;
import mps.project.harmony.Activities.proteinCalculator;
import mps.project.harmony.R;

import static android.content.Context.MODE_PRIVATE;

public class dashboard extends Fragment {

    String name;
    private RelativeLayout calorieCounter, proteinCalculator, heartRateScanner, FatCalculator, bmiCalculator, drinkWater, pedoMeter;
    private TextView userName;
    private TextView todayDate;
    private String currentDate;
    private TextView dailyProteinReq, bpm, bmi, fatPercentage, Calories, walk, water;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final SharedPreferences getShared = requireActivity().getSharedPreferences("user_details", MODE_PRIVATE);         //saved preference of user Details from login
        final SharedPreferences data = requireActivity().getSharedPreferences("user_data", MODE_PRIVATE);         //saved preference of user Details from login

        userName = view.findViewById(R.id.greeting);
        todayDate = view.findViewById(R.id.date);

        calorieCounter = view.findViewById(R.id.card1);
        heartRateScanner = view.findViewById(R.id.card2);
        proteinCalculator = view.findViewById(R.id.card3);
        drinkWater = view.findViewById(R.id.card6);
        bmiCalculator = view.findViewById(R.id.card7);
        FatCalculator = view.findViewById(R.id.card10);
        pedoMeter = view.findViewById(R.id.card5);

        dailyProteinReq = view.findViewById(R.id.dailyProteinReq);
        bpm = view.findViewById(R.id.bpm);
        bmi = view.findViewById(R.id.bmi);
        fatPercentage = view.findViewById(R.id.fatPercentage);
        Calories = view.findViewById(R.id.calories);
        walk = view.findViewById(R.id.steps);
        water = view.findViewById(R.id.litre);

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d,YYYY");
        Date date = new Date();
        currentDate = formatter.format(date);

        todayDate.setText(currentDate);

        if (getShared.getString("name", "Invalid").equals("")) {
            userName.setText("Invalid");
        } else {
            userName.append(getShared.getString("name", "Invalid"));
        }

        dailyProteinReq.setText(data.getString("protein", "0"));
        bpm.setText(data.getString("heartRate", "0"));
        bmi.setText(data.getString("bmi", "0"));
        fatPercentage.setText(data.getString("fat", "0"));
        Calories.setText(data.getString("calories", "0"));
        walk.setText(data.getString("walk", "0"));
        water.setText(data.getString("water", "0"));

        calorieCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mps.project.harmony.Activities.calorieCounter.class);
                startActivity(intent);
            }
        });

        proteinCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), proteinCalculator.class);
                startActivity(intent);
            }
        });

        heartRateScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HeartMeter.class);
                startActivity(intent);
            }
        });

        bmiCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mps.project.harmony.Activities.bmiCalculator.class);
                startActivity(intent);
            }
        });

        drinkWater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mps.project.harmony.Activities.drinkWater.class);
                startActivity(intent);
            }
        });

        FatCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), fatCalculator.class);
                startActivity(intent);
            }
        });

        pedoMeter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), mps.project.harmony.Activities.pedoMeter.class);
                startActivity(intent);
            }
        });

        return view;
    }


}