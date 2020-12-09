package com.example.myquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button falseButton;
    private Button trueButton;
    private ImageButton nextButton;
    private TextView questionTextview;
    private int currentQuestion = 0;
    private ImageButton previousButton;

    private Question[] questionBank = new Question[]{
          new Question(R.string.independance, true),
          new Question(R.string.victory, true),
          new Question(R.string.tagore, false),
          new Question(R.string.dhaka, true),
          new Question(R.string.president, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        falseButton = findViewById(R.id.false_button);
        trueButton = findViewById(R.id.true_button);
        questionTextview = findViewById(R.id.answer_text_view);
        nextButton = findViewById(R.id.next_button);
        previousButton = findViewById(R.id.pre_button);

        falseButton.setOnClickListener(this);
        trueButton.setOnClickListener(this);
        nextButton.setOnClickListener(this);
        previousButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.false_button:
                checkAnswer(false);
//                if (questionBank[currentQuestion].isAnswerTrue() == false){
//                    Toast.makeText(MainActivity.this,"Answer is correct!!", Toast.LENGTH_SHORT ).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this,R.string.false_text, Toast.LENGTH_SHORT ).show();
//                }
//
//                Log.d("falseButton", "clicked");
                break;

            case R.id.true_button:
                checkAnswer(true);
//                if (questionBank[currentQuestion].isAnswerTrue() == true){
//                    Toast.makeText(MainActivity.this,"Answer is correct!!", Toast.LENGTH_SHORT ).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this,"Answer is incorrect!!", Toast.LENGTH_SHORT ).show();
//                }
//                Log.d("trueButton", "clicked");
                break;

            case R.id.next_button:
                Log.d("next", "clicked");
                updateQuestion();
                break;
            case R.id.pre_button:
                updateQuestionPrevious();



        }



    }
    public void updateQuestion(){
        currentQuestion  = (currentQuestion +1) % questionBank.length;
        questionTextview.setText(questionBank[currentQuestion].getAnswerResId());
    }

    public void updateQuestionPrevious(){
        if (currentQuestion > 0) {
            currentQuestion = (currentQuestion - 1) % questionBank.length;
        }
        questionTextview.setText(questionBank[currentQuestion].getAnswerResId());

    }
    private void checkAnswer(boolean answer){
        boolean answerIs = questionBank[currentQuestion].isAnswerTrue();
        int string_name;
        if (answerIs == answer){
            string_name = R.string.correct;
            Toast.makeText(MainActivity.this , string_name, Toast.LENGTH_SHORT).show();
        }
        else{
            string_name = R.string.incorrect;
            Toast.makeText(MainActivity.this , string_name, Toast.LENGTH_SHORT).show();
        }

    }
}