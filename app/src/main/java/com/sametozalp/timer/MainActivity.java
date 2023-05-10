package com.sametozalp.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("Activity Started!");
        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.text);
    }

    public void button(View view){
        int countNumber = Integer.parseInt(editText.getText().toString());
        textView.setText(String.valueOf(countNumber));
        System.out.println(countNumber);
        button.setEnabled(false);
        new CountDownTimer(countNumber*1000,1000){
            public void onTick(long mili){
                textView.setText(""+mili/1000);
                System.out.println(mili/1000);

            }

            public void onFinish(){
                textView.setText("Finished!");
                button.setEnabled(true);
            }
        }.start();

    }

}