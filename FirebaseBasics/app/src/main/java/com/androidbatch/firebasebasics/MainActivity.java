package com.androidbatch.firebasebasics;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
 //  private Button btn_register;
    private EditText email,password;

    //decalring firebase auth
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_pass);

        //defining firebase auth
        firebaseAuth = FirebaseAuth.getInstance();


      //  btn_register = findViewById(R.id.btn_register);

//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    public void register(View view) {
        //getting data from input text
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        //registering thrugh firebase
        firebaseAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Registration failed"+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void openLoginPage(View view) {
        startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
}