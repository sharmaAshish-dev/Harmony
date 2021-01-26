package mps.project.harmony.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import mps.project.harmony.Activities.homeScreen;
import mps.project.harmony.R;

import static android.content.Context.MODE_PRIVATE;

public class login_page extends Fragment {

    private TextView loginBtn;
    private EditText uEmail, uPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            updateUI(currentUser);
        } else {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_page, container, false);

        mAuth = FirebaseAuth.getInstance();

        uEmail = view.findViewById(R.id.userEmail);
        uPassword = view.findViewById(R.id.userPassword);

        loginBtn = view.findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(view1 -> {
            if (uEmail.getText().toString().equals("") || uPassword.getText().toString().equals("")) {
                Toast.makeText(requireContext(), "Please Enter Details!", Toast.LENGTH_SHORT).show();
            } else {
                if (!uEmail.getText().toString().contains("@")) {
                    Toast.makeText(requireContext(), "Please Enter a valid Email ID", Toast.LENGTH_SHORT).show();
                } else {

                    progressDialog = new ProgressDialog(requireContext());
                    progressDialog.setMessage("Please wait");
                    progressDialog.show();

                    logUserIn(uEmail.getText().toString(), uPassword.getText().toString());
                }
            }
        });

        return view;
    }

    private void logUserIn(String email, String password) {

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        progressDialog.dismiss();
                        FirebaseUser user = mAuth.getCurrentUser();

                        fetchUserDetails(user.getUid());

                        updateUI(user);

                    } else {
                        // If sign in fails, display a message to the user.
                        progressDialog.hide();
                        Toast.makeText(requireContext(), "Authentication failed.",
                                Toast.LENGTH_SHORT).show();
                    }

                });

    }

    private void updateUI(FirebaseUser firebaseUser) {
        Intent alreadySignedIn = new Intent(requireContext(), homeScreen.class);
        alreadySignedIn.putExtra("user", firebaseUser);
        startActivity(alreadySignedIn);
        requireActivity().finish();
    }

    private void fetchUserDetails(String uID) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");

        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                SharedPreferences user_details = requireActivity().getSharedPreferences("user_details", MODE_PRIVATE);
                SharedPreferences.Editor editor = user_details.edit();

                editor.putString("uID", snapshot.child(uID).getValue().toString());
                editor.putString("Name", snapshot.child(uID).child("name").getValue().toString());
                editor.putString("Email", snapshot.child(uID).child("email").getValue().toString());

                editor.apply();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}