package com.example.bestburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.database.sqlite.SQLiteDatabase;
import android.widget.TextView;

public class page1 extends AppCompatActivity implements View.OnClickListener {
    Button btnAdd1, btnAdd2, btnAdd3, btnAdd4;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        btnAdd1 = (Button) findViewById(R.id.button_g1);
        btnAdd1.setOnClickListener(this);
        btnAdd2 = (Button) findViewById(R.id.button_g2);
        btnAdd2.setOnClickListener(this);
        btnAdd3 = (Button) findViewById(R.id.button_g3);
        btnAdd3.setOnClickListener(this);
        btnAdd4 = (Button) findViewById(R.id.button_g4);
        btnAdd4.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        switch (v.getId()) {

            case R.id.button_g1:
                TextView txt1 = findViewById(R.id.textView_g1);
                cv.put(DBHelper.KEY_NAME, txt1.getText().toString());
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 200);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_g2:
                TextView txt2 = findViewById(R.id.textView_g2);
                cv.put(DBHelper.KEY_NAME, txt2.getText().toString());
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 200);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_g3:
                TextView txt3 = findViewById(R.id.textView_g3);
                cv.put(DBHelper.KEY_NAME, txt3.getText().toString());
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 200);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_g4:
                TextView txt4 = findViewById(R.id.textView_g4);
                cv.put(DBHelper.KEY_NAME, txt4.getText().toString());
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 200);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
        }
        dbHelper.close();
    }

    public void pageBurgerStart(View v) {
        Intent intent = new Intent(this, page1.class);
        startActivity(intent);
    }

    public void pageColaStart(View v) {
        Intent intent = new Intent(this, page2.class);
        startActivity(intent);
    }

    public void pageBoxStart(View v) {
        Intent intent = new Intent(this, page3.class);
        startActivity(intent);
    }

    public void pageNavStart(View v) {
        Intent intent = new Intent(this, page4.class);
        startActivity(intent);
    }
}