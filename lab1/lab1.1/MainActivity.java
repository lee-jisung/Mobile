package com.example.leejisung.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    // make image object
    ImageView imageView;
    ImageView imageView2;
    int imageIndex = 0;  // for check image changing

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // link java and xml file

        imageView = findViewById(R.id.imageView); // get view to reference
        imageView2 = findViewById(R.id.imageView2);
    }

    public void onButton1Clicked(View v) {
        changeImage();
    }

    /**
     * if image index is 0, then set imageView's state to visible
     * and imageView2's state to invisible and set image index to 0.
     * if image index is 1, then set imageView's state to invisible
     * and imageView2's state to invisible and set image index to 1.
     */
    private void changeImage() {
        if (imageIndex == 0) {
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 1;
        } else if (imageIndex == 1) {
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 0;
        }
    }
}
