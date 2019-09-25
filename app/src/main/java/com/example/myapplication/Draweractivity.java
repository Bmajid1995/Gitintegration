package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;


public class Draweractivity extends AppCompatActivity {


     Toolbar toolbar;
     DrawerLayout myDrawer;
     ActionBarDrawerToggle myToggle;
     NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draweractivity);
        setUpToolbar();


        navigationView=(NavigationView)findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.nav_sharemenu:
                        Intent intent=new Intent();
                        intent.setAction(Intent.ACTION_SEND);
                        intent.putExtra(Intent.EXTRA_TEXT,"Hey! Check out the Lastest App for Chit Chat. You can download from: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
                        intent.setType("text/plain");
                        startActivity(intent);
                        break;
                    case R.id.nav_homemenu:
                        Toast.makeText(Draweractivity.this, "Working on it", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(Draweractivity.this,NumberorEmail.class);
//                        startActivity(intent);
                        break;
                    case R.id.nav_send:
                        Toast.makeText(Draweractivity.this, "Feedback", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_aboutusmenu:
                        Toast.makeText(Draweractivity.this, "Coming Soon", Toast.LENGTH_SHORT).show();
                        break;
                            case R.id.nav_settingsandmiscmenu:
                        Intent intent1=new Intent(Draweractivity.this,Settingandmisc.class);
                        startActivity(intent1);
                    case R.id.nav_profile:
                        Toast.makeText(Draweractivity.this, "Still Working on it", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_ratemenu:
                        Toast.makeText(Draweractivity.this, "Working on it", Toast.LENGTH_SHORT).show();


                }
                return false;
            }
        });

    }
private void setUpToolbar() {


        myDrawer = (DrawerLayout) findViewById(R.id.myDrawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        myToggle = new ActionBarDrawerToggle(this, myDrawer, R.string.Open, R.string.Close);
        myDrawer.addDrawerListener(myToggle);
        myToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (myToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    }






