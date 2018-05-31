package com.leejisung.lab6;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String NOTES = "mysdfile.txt";
    EditText editText;
    Button writeBtn;
    Button clrBtn;
    Button readBtn;
    Button finishBtn;

    private int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.txtData);
        writeBtn = findViewById(R.id.wrtSD);
        clrBtn = findViewById(R.id.clr);
        readBtn = findViewById(R.id.readSD);
        finishBtn = findViewById(R.id.finishApp);

        // when write button is clicked, get a data from edit text
        // and data is stored in sd card storage.
        writeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                try {
                    File sdCard = Environment.getExternalStorageDirectory();

                    File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
                    directory.mkdirs();
                    File file = new File(directory, NOTES);
                    FileOutputStream fOut = new FileOutputStream(file);
                    OutputStreamWriter osw = new OutputStreamWriter(fOut);

                    osw.write(editText.getText().toString());
                    osw.close();

                }catch(IOException e){ e.printStackTrace();}

                Toast.makeText(getApplicationContext(), "Done writing SD 'mysdfile.txt' ", Toast.LENGTH_SHORT).show();

            }
        });

        // when clear button is clicked, then erase text from edit text
        clrBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                editText.setText(null);
                Toast.makeText(getApplicationContext(), "Clear Edit Text! ", Toast.LENGTH_SHORT).show();
            }
        });

        // when read button is clicked, then read data from sd card
        // and data is set to the edit text.
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    File sdCard = Environment.getExternalStorageDirectory();

                    File directory = new File(sdCard.getAbsolutePath() + "/MyFiles");
                    directory.mkdirs();
                    File file = new File(directory, NOTES);
                    FileInputStream fIn = new FileInputStream(file);
                    InputStreamReader isr = new InputStreamReader(fIn);
                    BufferedReader reader = new BufferedReader(isr);

                    String str="";

                    str = reader.readLine();

                    editText.setText(str.toString());
                    isr.close();
                    reader.close();

                }catch(IOException e){ e.printStackTrace();}

                Toast.makeText(getApplicationContext(), "Done Reading SD 'mysdfile.txt' ", Toast.LENGTH_SHORT).show();

            }
        });

        // when finish button is clicked, then terminate app 
        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Finish this app!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });


    }
}
