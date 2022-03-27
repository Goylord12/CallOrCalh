package com.example.textcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TextCalculator extends AppCompatActivity {
    int fist;
    int sting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_calculator);
        Intent intent = getIntent();
        fist = intent.getIntExtra("first", fist);
        sting = intent.getIntExtra("second", sting);
        TextView mainView = findViewById(R.id.textView3);
        if (sting<0){
            mainView.setText(fist + " + " +"("+ sting + ")" + " = " + (fist+sting));
        }
        else{
            mainView.setText(fist + " + " + sting + " = " + (fist+sting));
        }
    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        TextView mainView = findViewById(R.id.textView3);
        outState.putString("mainText", String.valueOf(mainView.getText()));
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("mainText")) {
            int[] nums = savedInstanceState.getIntArray("nums");

        }
    }
}