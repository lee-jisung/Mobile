package com.leejisung.lab6;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    EditText ID;
    EditText name;
    Button openBtn;
    Button saveBtn;
    Button initialBtn;
    String studentId, studentName;
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ID = findViewById(R.id.sn);
        name = findViewById(R.id.name);
        openBtn = findViewById(R.id.open);
        saveBtn = findViewById(R.id.save);
        initialBtn = findViewById(R.id.initialize);

        // when "불러오기" button is clicked, then call openPreferences() function
        openBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPreferences();
            }
        });

        // when "저장하기" button is clicked, then get string from edit text
        // and call sharedPreferences() function
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentId = ID.getText().toString();
                studentName = name.getText().toString();
                sharedPreferences();
                Toast.makeText(getApplicationContext(), "Saved", Toast.LENGTH_SHORT).show();

            }
        });

        // when "초기화" button is clicked, then clear edit text.
        initialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ID.setText(null);
                name.setText(null);
            }
        });
    }

    // store string data to preference container.
    public void sharedPreferences(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("StudentID", studentId);
        toEdit.putString("StudentName", studentName);
        toEdit.commit();
    }

    // if specific key value is in the preference container
    // then read value of key and set value to edit text
    public void openPreferences(){
        sh_Pref = getSharedPreferences("Login Credentials", MODE_PRIVATE);
        if(sh_Pref != null && sh_Pref.contains("StudentID")){
            studentId = sh_Pref.getString("StudentID", "noID");
            ID.setText(studentId);
        }

        if(sh_Pref != null && sh_Pref.contains("StudentName")){
            studentId = sh_Pref.getString("StudentName", "noName");
            name.setText(studentName);
        }

    }
}
