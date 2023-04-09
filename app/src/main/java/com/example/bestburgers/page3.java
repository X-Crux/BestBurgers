package com.example.bestburgers;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class page3 extends AppCompatActivity implements View.OnClickListener {

    Button btnPay, btnClear;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        TextView orderList = findViewById(R.id.textView_check_list);
        TextView sumRow = findViewById(R.id.textView_bot);

        dbHelper = new DBHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String query = "select " + DBHelper.KEY_NAME + ", "
                + "sum(" + DBHelper.KEY_AMOUNT + ") as amount, "
                + "sum(" + DBHelper.KEY_PRICE + ") as price "
                + "from " + DBHelper.TABLE_ORDERS + " group by " + DBHelper.KEY_NAME;

        Cursor cursor = db.rawQuery(query, null);
        int summa = 0;

        if (cursor.moveToFirst()) {
            int nameIndex = cursor.getColumnIndex(DBHelper.KEY_NAME);
            int amountIndex = cursor.getColumnIndex(DBHelper.KEY_AMOUNT);
            int priceIndex = cursor.getColumnIndex(DBHelper.KEY_PRICE);

            orderList.setText("");
            do {
                String orderRow = cursor.getString(nameIndex) + ", " + cursor.getInt(amountIndex) + " шт. = " + cursor.getInt(priceIndex) + " руб.\n";
                orderList.append(orderRow);
                summa += cursor.getInt(priceIndex);
            } while (cursor.moveToNext());

            String orderSum = "Общая стоимость: " + summa + " руб";
            sumRow.setText(orderSum);
        } else {
            orderList.setText("Пусто");
            String orderSum = "Общая стоимость: " + summa + " руб";
            sumRow.setText(orderSum);
        }
        cursor.close();
        dbHelper.close();

        btnPay = (Button) findViewById(R.id.button_pay);
        btnPay.setOnClickListener(this);
        btnClear = (Button) findViewById(R.id.button_clear);
        btnClear.setOnClickListener(this);
    }

    private void showInfo(String title, String message, Boolean pay) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (pay) {
            builder.setTitle(title)
                    .setMessage(message)
                    .setCancelable(true)
                    .setPositiveButton("ОК", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            SQLiteDatabase db = dbHelper.getWritableDatabase();
                            dbHelper.onDelete(db);
                            dbHelper.close();

                            Intent intent = new Intent(page3.this, page3.class);
                            startActivity(intent);
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            builder.setTitle(title)
                    .setMessage(message)
                    .setCancelable(false)
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    dbHelper.onDelete(db);
                    dbHelper.close();

                    Intent intent = new Intent(page3.this, page3.class);
                    startActivity(intent);
                }
            })
                    .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button_pay:
                showInfo("Оплата", "Оплата завершена. В ближайшее время с вами свяжется оператор для уточнения заказа.", true);
                break;
            case R.id.button_clear:
                showInfo("Очистка", "Вы уверены, что хотите очистить корзину?", false);
                break;
        }
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