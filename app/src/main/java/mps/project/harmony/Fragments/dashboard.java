package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import mps.project.harmony.Activities.HeartMeter;
import mps.project.harmony.Activities.proteinCalculator;
import mps.project.harmony.R;

public class dashboard extends Fragment {

    String name;
    private RelativeLayout proteinCalculator, heartRateScanner, FatCalculator, bmiCalculator;
    private TextView userName;
    private TextView todayDate;
    private String currentDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TODO Fix app crashes when user opens app without login (pre logged state)
        //TODO Fix app crashes when user is logged from signup page
        //TODO Remove liquid swipe from login page and add normal activities with transition(0,0) for both entry and exit
        //TODO Create a check on splash for smooth data flow of user details
        //TODO Create a check on splash to check if user is logged in and if it is then fetch its data at the time of app start for smooth app performance

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        userName = view.findViewById(R.id.greeting);
        todayDate = view.findViewById(R.id.date);

        proteinCalculator = view.findViewById(R.id.card3);
        heartRateScanner = view.findViewById(R.id.card2);
        FatCalculator = view.findViewById(R.id.card10);
        bmiCalculator = view.findViewById(R.id.card7);

        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d,YYYY");
        Date date = new Date();
        currentDate = formatter.format(date);

        todayDate.setText(currentDate);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name = snapshot.child(FirebaseAuth.getInstance().getUid()).child("name").getValue().toString();
                userName.append(name);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

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

        return view;
    }
}