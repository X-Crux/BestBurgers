package com.example.bestburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class page2 extends AppCompatActivity implements View.OnClickListener {

    Button btnAdd11, btnAdd12, btnAdd13;
    Button btnAdd21, btnAdd22, btnAdd23;
    Button btnAdd31, btnAdd32, btnAdd33;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        btnAdd11 = (Button) findViewById(R.id.button_plus_11);
        btnAdd11.setOnClickListener(this);
        btnAdd12 = (Button) findViewById(R.id.button_plus_12);
        btnAdd12.setOnClickListener(this);
        btnAdd13 = (Button) findViewById(R.id.button_plus_13);
        btnAdd13.setOnClickListener(this);

        btnAdd21 = (Button) findViewById(R.id.button_plus_21);
        btnAdd21.setOnClickListener(this);
        btnAdd22 = (Button) findViewById(R.id.button_plus_22);
        btnAdd22.setOnClickListener(this);
        btnAdd23 = (Button) findViewById(R.id.button_plus_23);
        btnAdd23.setOnClickListener(this);

        btnAdd31 = (Button) findViewById(R.id.button_plus_31);
        btnAdd31.setOnClickListener(this);
        btnAdd32 = (Button) findViewById(R.id.button_plus_32);
        btnAdd32.setOnClickListener(this);
        btnAdd33 = (Button) findViewById(R.id.button_plus_33);
        btnAdd33.setOnClickListener(this);

        dbHelper = new DBHelper(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();

        TextView txt1 = findViewById(R.id.textView_c1);
        TextView txt2 = findViewById(R.id.textView_c2);
        TextView txt3 = findViewById(R.id.textView_c3);

        switch (v.getId()) {

            case R.id.button_plus_11:
                cv.put(DBHelper.KEY_NAME, txt1.getText().toString() + ", 800 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 130);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_12:
                cv.put(DBHelper.KEY_NAME, txt1.getText().toString() + ", 400 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 110);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_13:
                cv.put(DBHelper.KEY_NAME, txt1.getText().toString() + ", 300 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 90);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_21:
                cv.put(DBHelper.KEY_NAME, txt2.getText().toString() + ", 800 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 130);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_22:
                cv.put(DBHelper.KEY_NAME, txt2.getText().toString() + ", 400 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 110);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_23:
                cv.put(DBHelper.KEY_NAME, txt2.getText().toString() + ", 300 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 90);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_31:
                cv.put(DBHelper.KEY_NAME, txt3.getText().toString() + ", 800 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 130);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_32:
                cv.put(DBHelper.KEY_NAME, txt3.getText().toString() + ", 400 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 110);

                db.insert(DBHelper.TABLE_ORDERS, null, cv);
                break;
            case R.id.button_plus_33:
                cv.put(DBHelper.KEY_NAME, txt3.getText().toString() + ", 300 мл");
                cv.put(DBHelper.KEY_AMOUNT, 1);
                cv.put(DBHelper.KEY_PRICE, 90);

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