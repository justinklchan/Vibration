package com.example.vibration;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Vibrator v;
    EditText et1;
    Button startButton,stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        v=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        et1=(EditText)findViewById(R.id.et1);
        startButton=(Button)findViewById(R.id.button);
        stopButton=(Button)findViewById(R.id.button2);
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public void onStart(View view) {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createWaveform(new long[]{60000,0},
                    new int[]{Integer.parseInt(et1.getText().toString()),0},0));
        }
    }

    public void onStop(View view) {
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
        v.cancel();
    }
}