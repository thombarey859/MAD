package com.example.ise1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailsActivity extends AppCompatActivity {

    TextView tvName, tvNumber;

    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        tvName = findViewById(R.id.tvName);
        tvNumber = findViewById(R.id.tvNumber);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        number = intent.getStringExtra("number");

        tvName.setText("Name: " + name);
        tvNumber.setText("Number: " + number);
    }

    // 🔹 Call Contact
    public void callContact(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + number));
        startActivity(intent);
    }

    // 🔹 Message Contact
    public void messageContact(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("sms:" + number));
        intent.putExtra("sms_body", "Hello!");
        startActivity(intent);
    }
}