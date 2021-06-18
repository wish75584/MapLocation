package com.androidbatch.firebaseinsert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email, number, pass;
    Button btn;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        number = findViewById(R.id.mob);
        pass = findViewById(R.id.pass);
        btn = findViewById(R.id.btn_submit);
        firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference = firebaseDatabase.getReference("data");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  Name = name.getText().toString();
                String Email = email.getText().toString().trim();
                String Number = number.getText().toString();
                String Pass = pass.getText().toString().trim();
                String ID = reference.push().getKey();//generating id for putting data by id//unique id

                //setting data to the model//setting data temporary
                Data d = new Data(Name,Email,Number,Pass);

                reference.child(ID).setValue(d).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Databse updated successfully"+Name+"\n"+Email+"\n"+Number+"\n"
                                    +Pass+"\n"+ID+"\n", Toast.LENGTH_LONG).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "Error : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    public void openShowData(View view) {

        startActivity(new Intent(MainActivity.this,DataActivity.class));
    }
}