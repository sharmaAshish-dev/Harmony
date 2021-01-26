package mps.project.harmony.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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
import com.google.firebase.database.FirebaseDatabase;

import mps.project.harmony.Activities.homeScreen;
import mps.project.harmony.Models.User;
import mps.project.harmony.R;

import static android.content.Context.MODE_PRIVATE;

public class signUpPage extends Fragment {

    private FirebaseAuth mAuth;
    private EditText uName, uEmail, uPassword, uAge, uWeight, uHeight, uBlood;
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
        uAge = view.findViewById(R.id.userAge);
        uWeight = view.findViewById(R.id.userWeight);
        uHeight = view.findViewById(R.id.userHeight);
        uBlood = view.findViewById(R.id.userBloodGroup);

        signupBtn = view.findViewById(R.id.loginBtn);

        signupBtn.setOnClickListener(view1 -> {
            if (uName.getText().toString().equals("") || uEmail.getText().toString().equals("") || uPassword.getText().toString().equals("") ||
                    uAge.getText().toString().equals("") || uWeight.getText().toString().equals("") || uHeight.getText().toString().equals("") ||
                    uBlood.getText().toString().equals("")) {
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

                        String userName = uName.getText().toString();
                        String userEmail = uEmail.getText().toString();
                        String userPassword = uPassword.getText().toString();
                        String age = uAge.getText().toString();
                        String weight = uWeight.getText().toString();
                        String height = uHeight.getText().toString();
                        String blood = uBlood.getText().toString();

                        registerUser(userName, userEmail, userPassword, age, weight, height, blood);
                    }

                }

            }
        });

        return view;

    }

    private void registerUser(String displayName, String Email, String password, String age, String weight, String height, String blood) {

        mAuth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {


                    User user = new User(displayName, Email, password, age, weight, height, blood);

                    FirebaseDatabase.getInstance().getReference("users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user);

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("user_details", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", displayName);
                    editor.putString("email", Email);
                    editor.putString("password", password);
                    editor.putString("age", age);
                    editor.putString("weight", weight);
                    editor.putString("height", height);
                    editor.putString("blood", blood);
                    editor.apply();

                    updateUI();

                } else {
                    progressDialog.hide();
                    Toast.makeText(requireContext(), "SignUp Failed. Please try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void updateUI() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                progressDialog.dismiss();

                Intent signedIn = new Intent(requireContext(), homeScreen.class);
                startActivity(signedIn);
                requireActivity().finish();
            }
        }, 2000);


    }

}