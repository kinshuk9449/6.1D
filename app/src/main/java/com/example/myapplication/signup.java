package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup extends AppCompatActivity {
    EditText names, email, logpass, logcont;
    Button regi;
    FirebaseAuth abc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        //getSupportActionBar().setTitle("Sign Up");

        abc = FirebaseAuth.getInstance();
        names = findViewById(R.id.fname);
        logpass = findViewById(R.id.passwd);
        regi = findViewById(R.id.regs);
        email= findViewById(R.id.uemail);
        logcont = findViewById(R.id.contactno);
        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailid = email.getText().toString();
                String pwd = logpass.getText().toString();
                String fullName = names.getText().toString();
                String contactno= logcont.getText().toString();
                if(fullName.isEmpty()){
                    names.setError("Enter the Name");
                    names.requestFocus();
                }
                else if (mailid.isEmpty()){
                    email.setError("Enter the email");
                    email.requestFocus();
                }
                else if (contactno.isEmpty()){
                    logpass.setError("Enter the contact number");
                    logpass.requestFocus();
                }
                else if (pwd.isEmpty()){
                    logpass.setError("Enter the Password.");
                    logpass.requestFocus();
                }
                else {
                    abc.createUserWithEmailAndPassword(mailid, pwd).addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(signup.this, "Registration Unsuccessful, Please Try again!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                startActivity(new Intent(signup.this, Home.class));
                            }
                        }
                    });
                }
            }
        });
    }
}
