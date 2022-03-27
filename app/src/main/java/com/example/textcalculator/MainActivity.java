package com.example.textcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public int fist = 0;
    public int sting = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText firstTermInput = (EditText) findViewById(R.id.firstTermInput);
        EditText secondTermInput = (EditText) findViewById(R.id.secondTermInput);
        firstTermInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    firstTermInput.setText("");
                }
            }
        });
        secondTermInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    secondTermInput.setText("");
                }
            }
        });
    }

    public void add(View view){
        TextView fistTerm = findViewById(R.id.firstTermInput);
        TextView stingTerm = findViewById(R.id.secondTermInput);
        try {
            fist = Integer.parseInt(String.valueOf(fistTerm.getText()));
            sting = Integer.parseInt(String.valueOf(stingTerm.getText()));
            Intent intent = new Intent(this, TextCalculator.class);
            intent.putExtra("first", fist);
            intent.putExtra("second",sting);
            startActivity(intent);
        }
        catch (Exception ex){
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Залепуха");
            builder.setMessage("Ошибочные входные данные, кабанчиком вёл другие");
            builder.setPositiveButton("Ок", new DialogInterface.OnClickListener(){
                public void onClick(DialogInterface dialog, int id){
                    dialog.cancel();
                }
            });
            builder.show();
        }
    }


    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putIntArray("nums", new int[] {fist, sting});
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null && savedInstanceState.containsKey("nums")) {
            int[] nums = savedInstanceState.getIntArray("nums");
            fist = nums[0];
            sting = nums[1];
            if (!(fist == 0 && sting == 0)){
                resetUI();
            }

        }
    }
    protected void resetUI(){
        TextView leftScore = findViewById(R.id.firstTermInput);
        leftScore.setText(String.valueOf(fist));
        TextView rightScore = findViewById(R.id.secondTermInput);
        rightScore.setText(String.valueOf(sting));
    }
}