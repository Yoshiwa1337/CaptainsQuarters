package com.greenteam.captainsquarters;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Score_History extends AppCompatActivity {

    dbhelper DbHelper;
    TextView triviaScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score_history);

        DbHelper = new dbhelper(this);
        triviaScore = findViewById(R.id.trivia_score);
        printTriviaScore();

    }


    public void printTriviaScore(){
        String dbString = DbHelper.displayTriviaScore();
        triviaScore.setText(dbString);


    }
}