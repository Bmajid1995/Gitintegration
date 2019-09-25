package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Login extends AppCompatActivity {

    EditText username,emailid,password;
    Button signupbutton;
    TextView forwardtosignin;

    // Must initialize the firebase database reference !!
    FirebaseAuth auth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username=(EditText)findViewById(R.id.username);
        emailid=(EditText)findViewById(R.id.emailid);
        password=(EditText)findViewById(R.id.password);
        signupbutton=(Button)findViewById(R.id.signupbutton);
        forwardtosignin=(TextView)findViewById(R.id.forwardtosignin);

        auth =FirebaseAuth.getInstance();

        forwardtosignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Signin.class);
                startActivity(intent);
            }
        });

        // Here we work on the Sign up button that perform the task "Check the textutils is empty o not"?
        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username=username.getText().toString();
                String txt_email=emailid.getText().toString();
                String txt_password=password.getText().toString();

                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(Login.this, "All Fields are Required", Toast.LENGTH_SHORT).show();
                }else if (txt_password.length()<6){
                    Toast.makeText(Login.this, "Password must be atleast 6 characters", Toast.LENGTH_SHORT).show();
                }else {
                    register(txt_username, txt_email, txt_password);
                }
            }
});
    }
    // Here we create a variable os "Register" in which we work on the authentication and
    // create a directory in Firebase database so called userid that is also a child
    // and then we get that id
    private void register(final String username, String emailid, String password){

        auth.createUserWithEmailAndPassword(emailid,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser firebaseUser= auth.getCurrentUser();
                    assert firebaseUser != null;
                    String userid = firebaseUser.getUid();

                    databaseReference= FirebaseDatabase.getInstance().getReference("child").child(userid);
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("id",userid);
                    hashMap.put("username", username);
                    hashMap.put("imageURL","default");


                    databaseReference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Intent intent=new Intent(Login.this,Signin.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(intent);
                                finish();
                            }
                        }
                    });
                }else {
                    Toast.makeText(Login.this, "You can't Register with this email and password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
