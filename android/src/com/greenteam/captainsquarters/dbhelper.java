package com.greenteam.captainsquarters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {

    private static String DBname = "lone";
    private static String DBtable = "users";
    private static int DBversion = 1;

    private static String ID = "Id";
    private static String userName = "username";
    private static String Email = "email";
    private static String Password = "password";


    public dbhelper(@Nullable Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + DBtable + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +userName +" TEXT, "+Email + " TEXT," + Password + " TEXT)";
        db.execSQL(query);
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
}
