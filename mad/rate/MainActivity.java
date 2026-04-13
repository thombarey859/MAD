
package com.example.rate;


import android.os.Bundle;
import android.os.Handler;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView txtRating;
    ProgressBar progressBar;
    Button btnStart;

    int progress = 0;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar = findViewById(R.id.ratingBar);
        txtRating = findViewById(R.id.txtRating);
        progressBar = findViewById(R.id.progressBar);
        btnStart = findViewById(R.id.btnStart);

        // ⭐ RatingBar Event
        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            txtRating.setText("Rating: " + rating);
        });

        // ⏳ ProgressBar Event
        btnStart.setOnClickListener(v -> {
            progress = 0;

            new Thread(() -> {
                while (progress <= 100) {
                    progress += 10;

                    handler.post(() -> progressBar.setProgress(progress));

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
