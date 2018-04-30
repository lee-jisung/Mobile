package com.leejisung.lab3;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    RadioGroup radioGroup;
    RadioButton radMale;
    RadioButton radFemale;
    CheckBox smsBox;
    CheckBox mailBox;


    // get result from NewActivity and initiate editText, checkBox and radioButton
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1){
            editText.setText("");
            if(radMale.isChecked()) {
                radMale.setChecked(false);
            }
            if(radFemale.isChecked()){
                radFemale.setChecked(false);
            }
            if (smsBox.isChecked()) {
                smsBox.setChecked(false);
            }
            if (mailBox.isChecked()) {
                smsBox.setChecked(false);
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.edit);
        radioGroup = findViewById(R.id.radioGroup);
        radMale = findViewById(R.id.radMale);
        radFemale = findViewById(R.id.radFemale);
        smsBox = findViewById(R.id.smsBox);
        mailBox = findViewById(R.id.mailBox);

        // if button clicked, then make intent for call NewActivity
        // get a string from EditText and put into the intent
        // check whether radio button and check box is checked or not
        // and if checked then put checked state information into the intent
        // the last, request the result (using request code)
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                Intent intent = new Intent(getApplicationContext(), NewActivity.class);
                intent.putExtra("name", editText.getText().toString());

                if(radMale.isChecked()){
                    intent.putExtra("sex", "남");
                }
                if(radFemale.isChecked()){
                    intent.putExtra("sex", "여");
                }

                if(smsBox.isChecked()){
                    intent.putExtra("sms", "SMS");
                }

                if(mailBox.isChecked()){
                    intent.putExtra("mail", "e-mail");
                }
                startActivityForResult(intent,1);
            }
        });
    }
}
