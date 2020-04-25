package com.sleepycoder.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHelper db = new DBHelper(this);

        ContentValues cv = new ContentValues();
        cv.put("username","name");
        cv.put("password","pass");

        long rownumber = db.getWritableDatabase().insert("users",null,cv);

        Toast.makeText(this, (rownumber==-1)?"Failed to insert data":"Insert data successfully", Toast.LENGTH_SHORT).show();
    }
}
