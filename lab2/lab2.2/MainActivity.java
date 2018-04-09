package com.example.leejisung.android101;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.*;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText URL;
    Button nextBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  get view to reference
         */
        URL = findViewById(R.id.editText1);
        nextBtn = findViewById(R.id.button1);

        /**
         * if next button is clicked, get url from editText view and store in string variable (url)
         */
        nextBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String url = URL.getText().toString();

                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("URL", url);
                startActivity(intent);
            }
        });

    }

}
