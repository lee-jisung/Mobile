package com.example.leejisung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class lab2 extends AppCompatActivity {

    public EditText edit_name;

    public Button btn_print;
    public Button btn_clear;
    public TextView view_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // link java and xml file

        init();
    }

    /**
     * Function that get view to reference
     */
    private void init() {
        edit_name = findViewById(R.id.Name);
        btn_print = findViewById(R.id.Print);
        btn_clear = findViewById(R.id.Clear);
        view_print = findViewById(R.id.empty);
    }

    /**
     * set Edit Text view to empty string
     */
    public void clearClicked(View v){
        edit_name.setText("");
    }

    /**
     * Getting input from EditText and show this input string on the TextView
     */
    public void printClicked(View v){
        String text = "";
        text= edit_name.getText().toString();
        view_print.setText(text);
    }

}
