package com.greenteam.captainsquarters;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashMap;

public class Score_History extends AppCompatActivity {

    TriviaHelper triviaHelper;
    TextView topScore,allScores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_score_history);

        triviaHelper = new TriviaHelper(this);
        topScore = findViewById(R.id.top_score);
        allScores = findViewById(R.id.all_scores);
        printTriviaScore();

        ImageView backBtn = findViewById(R.id.back_btn);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                startActivity(intent);
            }
        });

    }


    public void printTriviaScore(){
        LinkedHashMap<String,String> scores =  triviaHelper.displayTriviaScore();

        topScore.setText("Top Score: " + scores.get("Top_Score"));
        allScores.setText(scores.get("All_Scores"));


    }


}