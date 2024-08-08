package com.greenteam.captainsquarters;


import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Trivia_Page extends AppCompatActivity implements View.OnClickListener {

    TextView totalQuestionsTextView;
    TextView questionsTextView;
    Button ansA,ansB,ansC,ansD;
    Button submitBtn;


    int score=0;
    int totalQuestion= QuestionAnswer.question.length;
    int currentQuestionIndex = 0;
    String selectedAnswer = "";

    dbhelper Dbhelper = new dbhelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.trivia_page);

        totalQuestionsTextView = findViewById(R.id.total_questions);
        questionsTextView = findViewById(R.id.question);
        ansA = findViewById(R.id.ans_A);
        ansB = findViewById(R.id.ans_B);
        ansC = findViewById(R.id.ans_C);
        ansD = findViewById(R.id.ans_D);
        submitBtn = findViewById(R.id.submit_btn);

        ansA.setOnClickListener(this);
        ansB.setOnClickListener(this);
        ansC.setOnClickListener(this);
        ansD.setOnClickListener(this);
        submitBtn.setOnClickListener(this);

        totalQuestionsTextView.setText("Total Questions : "+totalQuestion);

        loadNewQuestion();


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),Home_Page.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

        ansA.setBackgroundColor(Color.rgb(110,38,14));
        ansB.setBackgroundColor(Color.rgb(110,38,14));
        ansC.setBackgroundColor(Color.rgb(110,38,14));
        ansD.setBackgroundColor(Color.rgb(110,38,14));

        Button clickedButton=(Button)view;

        if(clickedButton.getId()==R.id.submit_btn){
            if(selectedAnswer.equals(QuestionAnswer.correctAnswers[currentQuestionIndex])){
                score++;
            }
            currentQuestionIndex++;
            loadNewQuestion();
            clickedButton.setBackgroundColor(Color. rgb(160,82,45));


        }else{
            selectedAnswer = clickedButton.getText().toString();
            clickedButton.setBackgroundColor(Color. rgb(160,82,45));
        }

//        if(clickedButton.getId()==R.id.back_btn){
//            Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
//            Intent intent = new Intent(getApplicationContext(),Home_Page.class);
//            startActivity(intent);
//        }


    }

    void loadNewQuestion(){

        if(currentQuestionIndex ==totalQuestion){
            finishQuiz();
            int Trivia_Score = score;
            Dbhelper.addTriviaScore(Trivia_Score);
//            Dbhelper.displayTriviaScore();
            return;
        }



        questionsTextView.setText(QuestionAnswer.question[currentQuestionIndex]);
        ansA.setText(QuestionAnswer.choices[currentQuestionIndex][0]);
        ansB.setText(QuestionAnswer.choices[currentQuestionIndex][1]);
        ansC.setText(QuestionAnswer.choices[currentQuestionIndex][2]);
        ansD.setText(QuestionAnswer.choices[currentQuestionIndex][3]);
    }

    void finishQuiz(){
        String passStatus = "";
        if(score > totalQuestion*0.60){
            passStatus = "Passed!";
        }else{
            passStatus = "Failed.";
        }

        new AlertDialog.Builder(this)
                .setTitle(passStatus)
                .setMessage("Score is "+score+" out of "+totalQuestion)
                .setPositiveButton("Play again!",(dialogInterface, i) -> restartQuiz())
                .setCancelable(false)
                .show();
    }

    void restartQuiz(){
        score = 0;
        currentQuestionIndex =0;
        loadNewQuestion();
    }


}