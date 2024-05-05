package com.example.hospitalmanagementsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasebook extends SQLiteOpenHelper {
    public Databasebook(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qrl2="create table book(name text,address text,contactnumber text,fee text)";
        sqLiteDatabase.execSQL(qrl2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void book(String name, String address, String contactnumber, String fee){
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("address",address);
        cv.put("contactno",contactnumber);
        cv.put("fees",fee);
        SQLiteDatabase db=getWritableDatabase();
        db.insert("book",null,cv);
        db.close();

    }
}
