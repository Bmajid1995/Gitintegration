package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignorSignup extends AppCompatActivity {

    Button signinbtnnew,signupbtnnew;

    FirebaseUser firebaseUser;

    @Override
    protected void onStart() {
        super.onStart();

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser !=null){
            Intent intent=new Intent(SignorSignup.this,Profile.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signor_signup);

        signinbtnnew=(Button)findViewById(R.id.signinbtnnew);
        signupbtnnew=(Button)findViewById(R.id.signupbtnnew);

        signinbtnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignorSignup.this,Signin.class);
                startActivity(intent);

            }

        });
        signupbtnnew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignorSignup.this,Login.class);
                startActivity(intent);
            }
        });
    }
}
