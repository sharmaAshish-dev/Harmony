package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mps.project.harmony.Activities.homeScreen;
import mps.project.harmony.R;

public class login_page extends Fragment {

    private TextView loginBtn;
    private EditText uEmail, uPassword;
    private FirebaseAuth mAuth;

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

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uEmail.getText().toString().equals("") || uPassword.getText().toString().equals("")) {
                    Toast.makeText(requireContext(), "Please Enter Details!", Toast.LENGTH_SHORT).show();
                } else {
                    if (!uEmail.getText().toString().contains("@")) {
                        Toast.makeText(requireContext(), "Please Enter a valid Email ID", Toast.LENGTH_SHORT).show();
                    } else {
                        logUserIn(uEmail.getText().toString(), uPassword.getText().toString());
                    }
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
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);

                    } else {
                        // If sign in fails, display a message to the user.
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
}