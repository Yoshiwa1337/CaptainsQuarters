package com.greenteam.captainsquarters;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class TriviaHelper extends SQLiteOpenHelper{

        private static String DBname = "lone";
        private static int DBversion = 3;

        long userId = 1;

        private static String Trivia_table = "Trivia_Score";
        private static String Trivia_ID = "Id";
        private static String Trivia_Score = "Score";
        private static String Trivia_UserId = "User_Id";

        public TriviaHelper(@Nullable Context context) {
            super(context, DBname, null, DBversion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            String Create_TriviaScore_Table ="CREATE TABLE " + Trivia_table + "("
                    + Trivia_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + Trivia_Score + " INTEGER NOT NULL,"
                    + Trivia_UserId + " INTEGER NOT NULL,"
                    + "FOREIGN KEY(" + Trivia_UserId + ") REFERENCES "
                    + "users" + "(id)"
                    + ")"  ;
            db.execSQL(Create_TriviaScore_Table);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Trivia_table );// Adam Code
            onCreate(db);
        }


        public void addTriviaScore(int TriviaScore){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues TriviaValues = new ContentValues();

            TriviaValues.put(Trivia_Score,TriviaScore);
            TriviaValues.put(Trivia_UserId,userId);
            long tId = db.insert(Trivia_table,null,TriviaValues);


        }

        public LinkedHashMap<String,String>  displayTriviaScore(){

            SQLiteDatabase db = getWritableDatabase();
            String query = "SELECT * FROM " + Trivia_table ;
            Cursor cursor = db.rawQuery(query,null);
            cursor.moveToFirst();

            PriorityQueue<Integer> scoreArr_Int = new PriorityQueue<Integer>();
            LinkedHashMap<String,String> values = new LinkedHashMap<String,String>();
            String allScores = "";

            int scoreCount = 1;
            while(!cursor.isAfterLast()) {
                int columnIndex = cursor.getColumnIndex("Score");
                int score_intValue = Integer.parseInt(cursor.getString(columnIndex));

                if(columnIndex != -1 && scoreCount<=5){

                    allScores += cursor.getString(columnIndex);
                    allScores += "\n";
                    scoreCount++;
                }
                scoreArr_Int.add(score_intValue);
                cursor.moveToNext();
            }

            String topScore = Integer.toString(Collections.max(scoreArr_Int));
            values.put("Top_Score", topScore);
            values.put("All_Scores",allScores);

            db.close();
            return values;
        }
}
