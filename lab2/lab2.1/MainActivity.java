package com.example.leejisung.android101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Age;
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = findViewById(R.id.editText1);
        Age = findViewById(R.id.editText2);
        button1 = findViewById(R.id.button1);

        /**
         * get view to reference
         */
        Button button1 = findViewById(R.id.button1);

        /**
         *  get name and age from user and store in string variables
         *  and deliver intent to the new activity
         */
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String name = Name.getText().toString();
                String age = Age.getText().toString();

                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("loginName", name);
                intent.putExtra("loginAge", age);
                startActivity(intent);
            }
        });

    }

}
