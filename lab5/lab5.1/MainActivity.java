package com.leejisung.lab5;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1;
    ImageView imageView2;
    EditText editText;
    Button button;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //reference view
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        //when button clicked, then start thread
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                DogThread thread1 = new DogThread(0);
                thread1.start();
                DogThread thread2 = new DogThread(1);
                thread2.start();
            }
        });

    }

    class DogThread extends Thread{
        int dogIndex;
        int stateIndex;

        // make array list to store images
        ArrayList<Integer> images = new ArrayList<>();

        // add images to array list
        public DogThread(int index){
            dogIndex = index;
            images.add(R.drawable.dog_eating);
            images.add(R.drawable.dog_standing);
            images.add(R.drawable.dog_studying);
        }

        //when thread is started, check dogIndex value
        // and if dogIndex is 0, then change dog image of first image view
        // if dogIndex is 1, then change dog image of second image view
        // sleep time is random that between 500~3000, so image is changed in random time
        public void run(){
            stateIndex = 0;
            for(int i=0; i<9; i++){
                final String msg = "dog #" + dogIndex + " state: " + stateIndex;
                handler.post(new Runnable(){
                    public void run(){
                        editText.append(msg + "\n");
                        if(dogIndex == 0){
                            imageView1.setImageResource(images.get(stateIndex));
                        }else if(dogIndex == 1){
                            imageView2.setImageResource(images.get(stateIndex));
                        }
                    }});

                try{
                    int sleepTime = getRandomTime(500, 3000);
                    Thread.sleep(sleepTime);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                // when stateIndex value is out of bound, then set value to 0
                stateIndex++;
                if(stateIndex >= images.size()){
                    stateIndex = 0;
                }
            }
        }

        // get a random time between min and max time
        public int getRandomTime(int min, int max){
            return min+(int)(Math.random() * (max-min));
        }

    }
}

