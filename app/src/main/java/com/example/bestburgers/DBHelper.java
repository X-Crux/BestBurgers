package com.example.bestburgers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "BestBurgersDB";
    public static final String TABLE_ORDERS = "orders";

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_AMOUNT = "amount";
    public static final String KEY_PRICE = "price";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_ORDERS + "("
                + KEY_ID + " integer primary key, "
                + KEY_NAME + " text, "
                + KEY_AMOUNT + " integer, "
                + KEY_PRICE + " integer" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " + TABLE_ORDERS);
        onCreate(db);
    }

    public void onDelete(SQLiteDatabase db) {
        db.delete(TABLE_ORDERS, null, null);
    }
}
