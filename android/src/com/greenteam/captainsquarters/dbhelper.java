package com.greenteam.captainsquarters;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbhelper extends SQLiteOpenHelper {

    private static String DBname = "lone";
    private static String DBtable = "users";
    private static int DBversion = 2;

    private static String ID = "Id";
    private static String username = "username";
    private static String email = "email";
    private static String password = "password";


    public dbhelper(@Nullable Context context) {
        super(context, DBname, null, DBversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = " CREATE TABLE " + DBtable + "("+ ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +username +" TEXT, "+email + " TEXT," + password + " TEXT)";
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
        values.put(username, username);
        values.put(email, email);
        values.put(password, password);

        db.insert(DBtable, null, values);  //insert method to insert data into table
//        db.close();
    }
}
