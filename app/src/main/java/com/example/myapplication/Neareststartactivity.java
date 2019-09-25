package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Neareststartactivity extends AppCompatActivity {

    private ViewPager mslideviewpager;
    private LinearLayout mDotslayout;
    private TextView[] mdots;
    private SlideAdapter slideAdapter;
    private Button mNextbutton;
    private Button mBackbutton;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.neareststartactivity);

        mslideviewpager = (ViewPager) findViewById(R.id.slideviewpager);
        mDotslayout = (LinearLayout) findViewById(R.id.dotslayout);
        mNextbutton=(Button)findViewById(R.id.nextbutton);
        mBackbutton=(Button)findViewById(R.id.backbutton);
        slideAdapter = new SlideAdapter(this);
        mslideviewpager.setAdapter(slideAdapter);


        addDotsIndicator(0);

        mslideviewpager.addOnPageChangeListener(viewListener);

        //Buttons on Click Listener

        mNextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslideviewpager.setCurrentItem(mCurrentPage +1);
            }
        });

        mBackbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslideviewpager.setCurrentItem(mCurrentPage -1);
            }
        });

    }

    public void addDotsIndicator(int position) {

        mdots = new TextView[2];
        mDotslayout.removeAllViews();

        for (int i = 0; i < mdots.length; i++) {

            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorPrimary));

            mDotslayout.addView(mdots[i]);
        }

        if (mdots.length > 0) {
            mdots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);

            mCurrentPage = i;
            if (i == 0){
             mNextbutton.setEnabled(true);
             mBackbutton.setEnabled(false);
             mBackbutton.setVisibility(View.INVISIBLE);

             mNextbutton.setText("Next");
             mBackbutton.setText("");

            }else if (i == mdots.length -1){

                mNextbutton.setEnabled(true);
                mBackbutton.setEnabled(true);
                mBackbutton.setVisibility(View.VISIBLE);

                mNextbutton.setText("Finish");
                mBackbutton.setText("Back");
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}


