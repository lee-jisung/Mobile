package com.leejisung.lab5;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    EditText editText;
    Button button;
    int value;
    int result = 1;
    String txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // reference view
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        //when button is clicked, then get a value from edit text
        // and starts the FactoTask
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                value = Integer.parseInt(editText.getText().toString());
                new FactoTask().execute();
            }
        });
    }

    private class FactoTask extends AsyncTask<Void, Integer, Void>{

        // set text view to default
        @Override
        protected void onPreExecute() {
            txt = "";
            textView1.setText(txt);
            textView2.setText("=?");
        }

        // pass integer value to onProgressUpdate method every 500 milli seconds
        @Override
        protected Void doInBackground(Void... voids) {
            for(int i = value; i>0; i--) {
                try {
                    Thread.sleep(500);
                    publishProgress(i);
                } catch (Exception e) {}
            }
            return null;
        }

        // set Text view to number that every 500 milli seconds
        @Override
        protected void onProgressUpdate(Integer... values) {
            txt += values[0].intValue() + " ";
            textView1.setText(txt);
            result *= values[0].intValue();
            super.onProgressUpdate(values);
        }

        // show result of factorial task and set result to default value
        @Override
        protected void onPostExecute(Void aVoid) {
            String r = Integer.toString(result);
            textView2.setText(r);
            result = 1;
        }
    }

}

