package mps.project.harmony.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mps.project.harmony.R;

public class signUpPage extends Fragment {

    private FirebaseAuth mAuth;
    private EditText uName, uEmail, uPassword;

    public signUpPage() {
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
        View view = inflater.inflate(R.layout.fragment_sign_up_page, container, false);

        mAuth = FirebaseAuth.getInstance();

        uName = view.findViewById(R.id.userName);
        uEmail = view.findViewById(R.id.userEmail);
        uPassword = view.findViewById(R.id.userPassword);

        if (uName.getText().toString().equals("") || uEmail.getText().toString().equals("") || uPassword.getText().toString().equals("")) {
            if (!uEmail.getText().toString().contains("@")) {
                Toast.makeText(requireContext(), "Please Enter Valid Email ID", Toast.LENGTH_SHORT).show();
            }
        } else {
            newUserSignUp(uEmail.getText().toString(), uPassword.getText().toString());
        }

        return view;

    }

    private void newUserSignUp(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        // Sign in success, update UI with the signed-in user's information
                        FirebaseUser user = mAuth.getCurrentUser();
                        updateUI(user);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(requireContext(), "SignUp failed.",
                                Toast.LENGTH_SHORT).show();
                    }
                    // ...
                });
    }

    private void updateUI(FirebaseUser firebaseUser) {
        Intent signedIn = new Intent(requireContext(), dashboard.class);
        signedIn.putExtra("user", firebaseUser);
        startActivity(signedIn);
        requireActivity().finish();
    }

}