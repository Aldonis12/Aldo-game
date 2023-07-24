package com.game.aldo_game;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QuizResults extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<QuestionsList> questionsList = QuestionsBank.getQuestions();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        final AppCompatButton startNewBtn = findViewById(R.id.startNewQuizBtn);
        final AppCompatButton mikisaka = findViewById(R.id.quitMaivana);
        final TextView correctAnswer = findViewById(R.id.correctAnswers);
        final TextView incorrectAnswer = findViewById(R.id.incorrectAnswers);

        final int getCorrect = getIntent().getIntExtra("Correct", 0);
        final int getIncorrect = getIntent().getIntExtra("Incorrect", 0);


        if (getCorrect == questionsList.size()){
            Toast.makeText(QuizResults.this,"Tena tsara!", Toast.LENGTH_SHORT).show();
        }

        if((getCorrect > (questionsList.size()/2)) && (getCorrect < questionsList.size())){
            Toast.makeText(QuizResults.this,"Efa tsara ny ezaka!", Toast.LENGTH_SHORT).show();
        }

        if((getCorrect == (questionsList.size()/2))){
            Toast.makeText(QuizResults.this,"Antonony fa mila ampiana ny ezaka!", Toast.LENGTH_SHORT).show();
        }

        if((getCorrect > 0) && (getCorrect < (questionsList.size()/2))){
            Toast.makeText(QuizResults.this,"Mila ezaka mafimafy!", Toast.LENGTH_SHORT).show();
        }

        if (getIncorrect == questionsList.size()){
            Toast.makeText(QuizResults.this,"Tena nandamoaka!", Toast.LENGTH_SHORT).show();
        }


        correctAnswer.setText(String.valueOf(getCorrect));
        incorrectAnswer.setText(String.valueOf(getIncorrect));

        startNewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this, QuizActivity.class));
                finish();
            }
        });

        mikisaka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuizResults.this, PasssageActivity.class));
                finish();
            }
        });
    }
    /*@Override
    public void onBackPressed(){
        startActivity(new Intent(QuizResults.this, QuizActivity.class));
        finish();
    }*/
}