package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Reviewofapplication extends AppCompatActivity {

    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviewofapplication);

        imageView=(ImageView)findViewById(R.id.welcomefrommainreview);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Reviewofapplication.this,Neareststartactivity.class);
                startActivity(intent);
//                Toast.makeText(Reviewofapplication.this, "Working on it", Toast.LENGTH_SHORT).show();
            }
        });



//        welcomefrommainreview.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(Reviewofapplication.this, "Working on it", Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
