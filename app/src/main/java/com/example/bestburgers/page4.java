package com.example.bestburgers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class page4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
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