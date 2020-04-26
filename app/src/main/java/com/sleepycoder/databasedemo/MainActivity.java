package com.sleepycoder.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = findViewById(R.id.data);

        DBHelper db = new DBHelper(this);

//        insertData(db);
//        selectData(db);
//        updateData(db);
//        deleteData(db);
    }

    private void deleteData(DBHelper db) {
        int rv = db.getWritableDatabase().delete("users", "username = ?", new String[]{"name2"});
        Toast.makeText(this, "Affected rows: " + rv, Toast.LENGTH_SHORT).show();
        selectData(db);
    }

    private void updateData(DBHelper db) {
        ContentValues cv = new ContentValues();
        cv.put("username", "name2");

        int rv = db.getWritableDatabase().update("users", cv, "username = ?", new String[]{"name1"});

        Toast.makeText(this, "Rows updated: " + rv, Toast.LENGTH_SHORT).show();
    }

    private void insertData(DBHelper db) {
        ContentValues cv = new ContentValues();
        cv.put("username", "name1");
        cv.put("password", "pass1");
        long rownumber = db.getWritableDatabase().insert("users", null, cv);
        Toast.makeText(this, (rownumber == -1) ? "Failed to insert data" : "Insert data successfully", Toast.LENGTH_SHORT).show();
    }

    private void selectData(DBHelper db) {
        data.setText("id");
        Cursor cursor = db.getReadableDatabase().query("users", null, null, null, null, null, null);

        Toast.makeText(this, "Is BeforeFirst? " + cursor.isBeforeFirst(), Toast.LENGTH_SHORT).show();
        while (cursor.moveToNext()) {
            data.setText(data.getText() + "\n" + cursor.getInt(0));
        }
    }
}
