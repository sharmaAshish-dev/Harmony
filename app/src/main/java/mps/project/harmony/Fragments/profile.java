package mps.project.harmony.Fragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import mps.project.harmony.Activities.walkThrough;
import mps.project.harmony.R;

import static android.content.Context.MODE_PRIVATE;

public class profile extends Fragment {

    private TextView name, name2, email, age, weight, height, blood;
    private TextView logoutBtn;

    public profile() {
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
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        final SharedPreferences getShared = requireActivity().getSharedPreferences("user_details", MODE_PRIVATE);         //saved preference of user Details from login

        name = view.findViewById(R.id.userNameCard);
        name2 = view.findViewById(R.id.userName);
        email = view.findViewById(R.id.userEmail);
        age = view.findViewById(R.id.userAge);
        weight = view.findViewById(R.id.userWeight);
        height = view.findViewById(R.id.userHeight);
        blood = view.findViewById(R.id.userBlood);

        logoutBtn = view.findViewById(R.id.logoutBtn);

        if (getShared.getString("name", "Invalid").equals("")) {
            name.setText("Invalid");
        } else {
            name.setText(getShared.getString("name", "Invalid"));
        }

        if (getShared.getString("name", "Invalid").equals("")) {
            name2.setText("Invalid");
        } else {
            name2.setText(getShared.getString("name", "Invalid"));
        }

        if (getShared.getString("email", "Invalid").equals("null")) {
            email.setText("--");
        } else {
            email.setText(getShared.getString("email", "Invalid"));
        }

        if (getShared.getString("age", "Invalid").equals("null")) {
            age.setText("--");
        } else {
            age.setText(getShared.getString("age", "Invalid"));
        }

        if (getShared.getString("weight", "Invalid").equals("null")) {
            weight.setText("--");
        } else {
            weight.setText(getShared.getString("weight", "Invalid"));
        }

        if (getShared.getString("height", "Invalid").equals("null")) {
            height.setText("--");
        } else {
            height.setText(getShared.getString("height", "Invalid"));
        }

        if (getShared.getString("blood", "Invalid").equals("null")) {
            blood.setText("--");
        } else {
            blood.setText(getShared.getString("blood", "Invalid"));
        }

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                requireActivity().getSharedPreferences("user_details", MODE_PRIVATE).edit().clear().apply();         //saved preference of user Details from login

                Intent dashBoardIntent = new Intent(requireActivity(), walkThrough.class);

                startActivity(dashBoardIntent);

                // closing the activity
                requireActivity().finish();

            }
        });

        return view;
    }
}