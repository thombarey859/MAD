package com.example.background;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {

    Button buttonA, buttonB, buttonC;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainLayout = findViewById(R.id.main);

        // Bind buttons
        buttonA = findViewById(R.id.button);
        buttonB = findViewById(R.id.button2);
        buttonC = findViewById(R.id.button4);

        // Button A → screen RED
        buttonA.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.RED)
        );

        // Button B → screen GREEN
        buttonB.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.GREEN)
        );

        // Button C → screen BLUE
        buttonC.setOnClickListener(v ->
                mainLayout.setBackgroundColor(Color.BLUE)
        );
    }
}
