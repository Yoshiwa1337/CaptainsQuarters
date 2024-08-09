package com.greenteam.captainsquarters;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class dbhelper extends SQLiteOpenHelper {

    private static String DBname = "lone";
    private static int DBversion = 3;

    private static String DBtable = "users";
    private static String ID = "Id";
    private static String userName = "username";
    private static String Email = "email";
    private static String Password = "password";

    long userId = 1;

    public dbhelper(@Nullable Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_Users_Table = " CREATE TABLE " + DBtable + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + userName +" TEXT, "
                + Email + " TEXT,"
                + Password + " TEXT)";


        db.execSQL(Create_Users_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + DBtable);
        onCreate(db);
    }

    public void addUser(String username,String email,String password){
        SQLiteDatabase  db = this.getWritableDatabase();  //help you insert data

        ContentValues values = new ContentValues();
        values.put(userName, username);
        values.put(Email, email);
        values.put(Password, password);

        db.insert(DBtable, null, values);  //insert method to insert data into table

    }

//    public Boolean checkUser(String email, String password)
//    {
//        SQLiteDatabase db = this.getWritableDatabase();
//        String[] columns = {ID};
//        String selection = Email + " = ? AND " + Password + " = ? ";
//        String[] selectionArgs = {email, password};
//        Cursor cursor = db.query(DBtable, columns, selection, selectionArgs, null, null, null);
//        int cursorCount = cursor.getCount();
//        cursor.close();
//        db.close();
//        return  cursorCount > 0;
//    }



}
