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
import java.util.PriorityQueue;

public class dbhelper extends SQLiteOpenHelper {

    private static String DBname = "lone";
    private static int DBversion = 2;

    private static String DBtable = "users";
    private static String ID = "Id";
    private static String userName = "username";
    private static String Email = "email";
    private static String Password = "password";

    long userId = 1;

    //Adam code line 21 - 25
//    private static String Trivia_table = "Trivia_Score";
//    private static String Trivia_ID = "Id";
//    private static String Trivia_Score = "Score";
//    private static String Trivia_UserId = "User_Id";
    //Adam code


    public dbhelper(@Nullable Context context) {
        super(context, DBname, null, DBversion);
    }


//    @Override
//    public void onConfigure(SQLiteDatabase db) {
//        super.onConfigure(db);
//        db.execSQL("PRAGMA foreign_keys=ON");
//    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String Create_Users_Table = " CREATE TABLE " + DBtable + "("
                + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + userName +" TEXT, "
                + Email + " TEXT,"
                + Password + " TEXT)";
        db.execSQL(Create_Users_Table);

        //Adam Code line 44-51d
//        String Create_TriviaScore_Table ="CREATE TABLE " + Trivia_table + "("
//                + Trivia_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + Trivia_Score + " INTEGER NOT NULL,"
//                + Trivia_UserId + " INTEGER NOT NULL,"
//                + "FOREIGN KEY(" + Trivia_UserId + ") REFERENCES "
//                + DBtable + "(" + ID +")"
//                + ")"  ;
//        db.execSQL(Create_TriviaScore_Table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + DBtable);
//        db.execSQL("DROP TABLE IF EXISTS " + Trivia_table );// Adam Code
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

    // insert trivia score into trivia table
//    public void addTriviaScore(int TriviaScore){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues TriviaValues = new ContentValues();
//
//        TriviaValues.put(Trivia_Score,TriviaScore);
//        TriviaValues.put(Trivia_UserId,userId);
//        long tId = db.insert(Trivia_table,null,TriviaValues);
//
//
//    }
//
//
//    public String displayTriviaScore(){
//
//        String dbString = "";
//
//        SQLiteDatabase db = getWritableDatabase();
////        String query = "SELECT * FROM " + Trivia_table + " WHERE " + Trivia_ID + " =1 ";
//        String query = "SELECT * FROM " + Trivia_table ;
////        String query = "SELECT * FROM Trivia_Score";
//        Cursor cursor = db.rawQuery(query,null);
//        cursor.moveToFirst();
//
//        PriorityQueue<String> scoreArr = new PriorityQueue<String>(5);
//
//        String testString = "";
//
//        while(!cursor.isAfterLast()) {
//            int columnIndex = cursor.getColumnIndex("Score");
//
//            if(columnIndex != -1){
//                dbString += cursor.getString(columnIndex);
//                dbString += "\n";
//                scoreArr.add(cursor.getString(columnIndex));
//            }
//
//            cursor.moveToNext();
//
//        }
//
//        int scoreCount = 1;
//        for(String score: scoreArr){
//            if(scoreCount<=5) {
//                testString += score;
//            }
//            scoreCount++;
//        }
//
//
//
//
//
//        db.close();
//        return testString;
//
//    }



}
