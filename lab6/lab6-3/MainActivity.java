package com.leejisung.lab6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ListView listView;
    EditText ID;
    EditText name;
    Button updateBtn;
    Button deleteBtn;
    String studentId, studentName;
    String[] studentInfo;

    SQLiteDatabase db;
    DBHelper helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        ID = findViewById(R.id.studentId);
        updateBtn = findViewById(R.id.update);
        deleteBtn = findViewById(R.id.delete);
        listView = findViewById(R.id.listView);

        // make student database
        helper = new DBHelper(MainActivity.this, "student.db", null, 1);

        // when "추가" button is clicked, first check whether name and number is not empty
        // if one of them is empty, then print error message
        // and the other get a string from Edit Text and store in database
        // and call invalidate function to update list view.
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ID.getText().toString().length() == 0 || name.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "모든 항목을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    studentName = name.getText().toString();
                    studentId = ID.getText().toString();
                    insert(studentName, studentId);
                    invalidate();
                }
            }
        });

        // when "삭제" button is clicked, first check whether name is not empty
        // if name is not entered, then print error message
        // and the other get name and delete from database
        // and call invalidate function to update list view
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length() == 0) {
                    Toast.makeText(getApplicationContext(), "이름을 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    studentName = name.getText().toString();
                    delete(studentName);
                    invalidate();
                }
            }
        });
    }

    // insert data to database
    public void insert(String name, String studentNo) {
        db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("studentNo", studentNo);
        db.insert("student", null, values);
        Log.i("insert", "성공");
    }

    // delete data from database
    public void delete(String name) {
        db = helper.getWritableDatabase();
        db.delete("student", "name=?", new String[]{name});
        Log.i("delete", "성공");

    }

    // search data from database.
    public void select(){
        db = helper.getReadableDatabase();
        Cursor c = db.query("student", null, null,null,null,null,null);

        studentInfo = new String[c.getCount()];
        int count = 0;
        while(c.moveToNext()){
            studentInfo[count] = c.getString(c.getColumnIndex("name")) + " " + c.getString(c.getColumnIndex("studentNo"));
            count++;
        }
        c.close();
    }

    // update list view with student information
    public void invalidate(){
        select();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, studentInfo);
        listView.setAdapter(adapter);
    }
}
