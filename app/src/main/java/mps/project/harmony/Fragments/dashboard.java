package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;

import mps.project.harmony.Activities.heartBeatMeasure;
import mps.project.harmony.R;

public class dashboard extends Fragment {

    RelativeLayout heartRateScanner;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        heartRateScanner = view.findViewById(R.id.card2);

        heartRateScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), heartBeatMeasure.class);
                startActivity(intent);
            }
        });

        return view;
    }
}