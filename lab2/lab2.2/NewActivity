package com.example.leejisung.android101;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class NewActivity extends AppCompatActivity {

    TextView textView;
    Button goBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        /**
         * get view to reference
         */
        textView = findViewById(R.id.textView1);
        goBtn = findViewById(R.id.goBtn);
        backBtn = findViewById(R.id.backBtn);

        final Intent passedIntent = getIntent();
        final String passedUrl = passedIntent.getStringExtra("URL");
        textView.setText(passedUrl); // set textview with url that user entered

        /**
         * when go button is clicked, if passedUrl string variable is not empty, then show webpage
         * if passedUrl string variable is empty, then print toast message on the screen
         */
        goBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(!passedUrl.isEmpty()){
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+passedUrl));
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "주소를 다시 입력해주세요.",Toast.LENGTH_LONG).show();
                }
            }
        });

        /**
         * when back button is clicked, then return first screen and print toast message on the screen
         */
        backBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "뒤로가기 버튼이 눌렸습니다.", Toast.LENGTH_LONG).show();
                finish();
            }
        });

    }
}
