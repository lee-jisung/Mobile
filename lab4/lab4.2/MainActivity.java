package com.leejisung.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    LinearLayout slide;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();

        // if open page button is clicked, then show sliding page with left slide animation
        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.left_slide);
                slide.startAnimation(anim);
                slide.setVisibility(View.VISIBLE);
            }
        });

        // if close page button is clicked, then disappear sliding page with right slide animation
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.right_slide);
                slide.startAnimation(anim);
                slide.setVisibility(View.INVISIBLE);
            }
        });
    }

    //initialize view
    public void init(){
        slide = findViewById(R.id.slide_area);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
    }
}
