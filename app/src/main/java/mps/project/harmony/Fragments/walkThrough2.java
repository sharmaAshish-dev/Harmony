package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mps.project.harmony.Activities.Login_signup;
import mps.project.harmony.MainActivity;
import mps.project.harmony.R;

public class walkThrough2 extends Fragment {

    private TextView skipBtn;

    public walkThrough2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_walk_through2, container, false);

        skipBtn = view.findViewById(R.id.skipBtn);

        skipBtn.setOnClickListener(view1 -> {
            Intent skipIntent = new Intent();
            skipIntent.setClass(requireContext(), Login_signup.class);
            startActivity(skipIntent);
        });

        return view;
    }
}