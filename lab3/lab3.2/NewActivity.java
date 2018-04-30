package com.leejisung.lab3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity{

    Intent intent;
    TextView nameView;
    TextView sexView;
    TextView receiveView;
    Button button;

    // get intent and get a string values from intent
    // display strings on the screen
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        nameView = findViewById(R.id.nameView);
        sexView = findViewById(R.id.sexView);
        receiveView = findViewById(R.id.mailView);
        button = findViewById(R.id.button);

        intent = getIntent();
        if(intent != null) {
            nameView.setText(intent.getStringExtra("name").toString());
            sexView.setText(intent.getStringExtra("sex"));
            if(intent.getStringExtra("sms")!=null && intent.getStringExtra("mail")!=null){
                receiveView.setText(intent.getStringExtra("sms") + " & " + intent.getStringExtra("mail"));
            }
            else if(intent.getStringExtra("sms")!=null){
                receiveView.setText(intent.getStringExtra("sms"));
            }
            else if(intent.getStringExtra("mail")!=null){
                receiveView.setText(intent.getStringExtra("mail"));
            }
        }
        //if button clicked, then pass the result to MainActivity and close current activity
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

}
