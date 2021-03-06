package com.example.leejisung.android101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);


        Intent passedIntent = getIntent();
        /**
         * if delivered intent is not empty, then get name and age and store in string variables
         * show toast message on the screen with name and age
         */
        if(passedIntent != null){
            String loginName = passedIntent.getStringExtra("loginName");
            String loginAge = passedIntent.getStringExtra("loginAge");
            Toast.makeText(getApplicationContext(), "Student info : " + loginName + ", " + loginAge,Toast.LENGTH_LONG).show();

        }

        /**
         * when close button is clicked, then close screen and return to first screen
         */
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
