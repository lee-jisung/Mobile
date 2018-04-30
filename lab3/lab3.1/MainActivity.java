package com.leejisung.lab3;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        registerForContextMenu(button);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Button Menu");
        menu.add(0,0,0,"Red");
        menu.add(0,1,1,"Green");
        menu.add(0,2,2,"Blue");
    }

    public boolean onContextItemSelected(MenuItem item){
        int id = item.getItemId();
        switch(id){
            case 0:
                button.setTextColor(Color.RED);
                break;
            case 1:
                button.setTextColor(Color.GREEN);
                break;
            case 2:
                button.setTextColor(Color.BLUE);
                break;
            default:break;
        }
        return super.onContextItemSelected(item);
    }
}
