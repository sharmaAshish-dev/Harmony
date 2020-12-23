package mps.project.harmony.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import mps.project.harmony.Activities.homeScreen;
import mps.project.harmony.R;

public class signUpPage extends Fragment {

    private FirebaseAuth mAuth;
    private EditText uName, uEmail, uPassword;
    private ProgressDialog progressDialog;
    private TextView signupBtn;

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
        signupBtn = view.findViewById(R.id.loginBtn);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (uName.getText().toString().equals("") || uEmail.getText().toString().equals("") || uPassword.getText().toString().equals("")) {
                    Toast.makeText(requireContext(), "Please Fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    if (!uEmail.getText().toString().contains("@")) {
                        Toast.makeText(requireContext(), "Please Enter Valid Email ID", Toast.LENGTH_SHORT).show();
                    } else {

                        if (uPassword.getText().toString().length() < 6) {
                            Toast.makeText(requireContext(), "Password length should be more than 8", Toast.LENGTH_SHORT).show();
                        } else {
                            progressDialog = new ProgressDialog(requireContext());
                            progressDialog.setMessage("Please wait");
                            progressDialog.show();

                            String userEmail = uEmail.getText().toString();
                            String userPassword = uPassword.getText().toString();

                            registerUser("", userEmail, userPassword);
                        }

                    }

                }
            }
        });

        return view;

    }

    private void registerUser(String displayName, String Email, String password) {

        mAuth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    progressDialog.dismiss();
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    updateUI(user);

                } else {
                    progressDialog.hide();
                    Toast.makeText(requireContext(), "SignUp Failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void updateUI(FirebaseUser firebaseUser) {
        Intent signedIn = new Intent(requireContext(), homeScreen.class);
        signedIn.putExtra("user", firebaseUser);
        startActivity(signedIn);
        requireActivity().finish();
    }

}