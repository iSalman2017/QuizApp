package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private double mScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button mSubmitBtn;
        Button mTryAgainBtn;

        mSubmitBtn = (Button) findViewById(R.id.submit_btn);
        mTryAgainBtn = (Button) findViewById(R.id.try_again_btn);

        //Submit Button click listener
        mSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitScore();
                Toast.makeText(MainActivity.this, "You got " + mScore + "Points of 20.", Toast.LENGTH_SHORT).show();
                mScore = 0;
            }
        });

        //Try Again Button click listener
        mTryAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });


    }

    //submitScore Method to Store the score based on correct answers
    public void submitScore() {
        RadioButton q1Choice3 = (RadioButton) findViewById(R.id.q1_choice3_radio);
        CheckBox q2Choice1 = (CheckBox) findViewById(R.id.q2_choice1_checkbox);
        CheckBox q2Choice2 = (CheckBox) findViewById(R.id.q2_choice2_checkbox);
        CheckBox q2Choice3 = (CheckBox) findViewById(R.id.q2_choice3_checkbox);
        CheckBox q2Choice4 = (CheckBox) findViewById(R.id.q2_choice4_checkbox);
        RadioButton q3Choice1 = (RadioButton) findViewById(R.id.q3_choice1_radio);
        EditText q4Answer = (EditText) findViewById(R.id.q4_choice1_edit_text);

        boolean hasQ1Choice3 = q1Choice3.isChecked();
        boolean hasQ2Choice1 = q2Choice1.isChecked();
        boolean hasQ2Choice2 = q2Choice2.isChecked();
        boolean hasQ2Choice3 = q2Choice3.isChecked();
        boolean hasQ2Choice4 = q2Choice4.isChecked();
        boolean hasQ3Choice1 = q3Choice1.isChecked();
        String hasQ4Answer = q4Answer.getText().toString();


        if (hasQ1Choice3) {
            mScore += 5;
        }
        if (hasQ2Choice2 && hasQ2Choice4 && !hasQ2Choice1 && !hasQ2Choice3) {
            mScore += 5;
        }else{
            Toast.makeText(MainActivity.this, "Please select all possible answer", Toast.LENGTH_SHORT).show();
        }
        if (hasQ3Choice1) {
            mScore += 5;
        }
        if (hasQ4Answer.equals("15")) {
            mScore += 5;
        }
    }


}
