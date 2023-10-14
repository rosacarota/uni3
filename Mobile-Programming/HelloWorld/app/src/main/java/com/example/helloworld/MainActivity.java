package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
    }

    public void changeColor(View v) {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        textView.setBackgroundColor(Color.rgb(r, g, b));
    }
}