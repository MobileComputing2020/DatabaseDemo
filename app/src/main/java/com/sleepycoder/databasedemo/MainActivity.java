package com.sleepycoder.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView data = findViewById(R.id.data);
        data.setText("id");

        DBHelper db = new DBHelper(this);

//        ContentValues cv = new ContentValues();
//        cv.put("username","name1");
//        cv.put("password","pass1");
//
//        long rownumber = db.getWritableDatabase().insert("users",null,cv);
//
//        Toast.makeText(this, (rownumber==-1)?"Failed to insert data":"Insert data successfully", Toast.LENGTH_SHORT).show();

        Cursor cursor = db.getReadableDatabase().query("users", null, "username = ?", new String[]{"name2"}, null, null, null);

        Toast.makeText(this, "Is BeforeFirst? " + cursor.isBeforeFirst(), Toast.LENGTH_SHORT).show();
        while (cursor.moveToNext()) {
            data.setText(data.getText() + "\n" + cursor.getInt(0));
        }

    }
}
