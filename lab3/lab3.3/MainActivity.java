package com.leejisung.lab3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by leejisung on 2018-04-25.
 */

public class MainActivity extends AppCompatActivity{

    Button btn1;
    Button btn2;

    Fragment1 fragment1;
    Fragment2 fragment2;

    @Override
    public void onCreate(Bundle stateInstanceState){
        super.onCreate(stateInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    // get view to reference and make new fragment variables 
    public void init(){

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();

    }

    // button event handler function
    // if TAB1 button clicked, then display fragment1 on the screen
    // if TAB2 button clicked, then display fragment2 on the screen
    private void setListener(){

        btn1.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment1).commit();
           }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment2).commit();
            }
        });

    }

}
