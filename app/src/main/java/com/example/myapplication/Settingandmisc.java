package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Settingandmisc extends AppCompatActivity {

//    Switch myswitch;

    ListView listView;
    // Here you Create an Array and initialize objects
    String mtitle[] = {"What's New","Feedback","FAQs."};
    String mdescription[] = {"See Whats new in this Application","Let us know if you have any Suggestion","If you have any problem you can use FAQs."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            setTheme(R.style.darktheme);
//        } else setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingandmisc);

//        myswitch = (Switch) findViewById(R.id.myswitch);

//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            myswitch.setChecked(true);
//        }
//        myswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//                    restartApp();
//                } else {
//                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//                    restartApp();
//                }
//            }
//        });
//    }
//    public void restartApp(){
//        Intent intent=new Intent(getApplicationContext(),Settingandmisc.class);
//        startActivity(intent);
//        finish();


        listView=findViewById(R.id.listview);
        //Now Create an Adapter

        MyAdapter myAdapter=new MyAdapter(this,mtitle,mdescription);
        listView.setAdapter(myAdapter);

        // Set item click on list View

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position ==0){
                    Intent intent=new Intent(Settingandmisc.this,Frequentaskquestions.class);
                    startActivity(intent);

                }
                if (position ==1){
                    Toast.makeText(Settingandmisc.this, "Are you There ?", Toast.LENGTH_SHORT).show();

                }
                if (position ==0){
                    Toast.makeText(Settingandmisc.this, "Why you are Here", Toast.LENGTH_SHORT).show();

                }

            }
        });



    }
    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String mtitle[];
        String mdescription[];

        MyAdapter (Context c ,String title[], String description[]) {

            super(c,R.layout.forlistview,R.id.textviewforlistview,title);
            this.context = c;
            this.mtitle =title;
            this.mdescription =description;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater=(LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View view=layoutInflater.inflate(R.layout.forlistview, parent, false);
            TextView mytitle= view.findViewById(R.id.textviewforlistview);
            TextView mydescription=view.findViewById(R.id.textviewtwoforlistview);


            // Now set our resources on views

            mytitle.setText(mtitle[position]);
            mydescription.setText(mdescription[position]);
            return view;
        }
    }
}
