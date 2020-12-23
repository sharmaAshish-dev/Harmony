package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import mps.project.harmony.Activities.HeartMeter;
import mps.project.harmony.Activities.proteinCalculator;
import mps.project.harmony.R;

public class dashboard extends Fragment {

    RelativeLayout proteinCalculator, heartRateScanner, FatCalculator, bmiCalculator;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        proteinCalculator = view.findViewById(R.id.card3);
        heartRateScanner = view.findViewById(R.id.card2);
        FatCalculator = view.findViewById(R.id.card10);
        bmiCalculator = view.findViewById(R.id.card7);

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

            }
        });


        return view;
    }
}