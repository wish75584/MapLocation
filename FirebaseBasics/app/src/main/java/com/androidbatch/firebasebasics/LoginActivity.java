package com.androidbatch.firebasebasics;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText et_login_email, et_login_pass;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_login_email = findViewById(R.id.et_login_email);
        et_login_pass = findViewById(R.id.et_login_pass);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void loginFirebase(View view) {
        String Email = et_login_email.getText().toString().trim();
        String Pass = et_login_pass.getText().toString().trim();
        firebaseAuth.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Login Sucessful : Welcome user" + Email, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,HomePage.class));
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(LoginActivity.this, "" + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}