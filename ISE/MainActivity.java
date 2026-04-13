package com.example.ise1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_CONTACT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 🔹 Open Contacts
    public void openContacts(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK,
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent, PICK_CONTACT);
    }

    // 🔹 Get selected contact
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT && resultCode == RESULT_OK) {

            if (data != null) {
                android.net.Uri contactUri = data.getData();

                android.database.Cursor cursor = getContentResolver().query(
                        contactUri,
                        null,
                        null,
                        null,
                        null
                );

                if (cursor != null && cursor.moveToFirst()) {

                    String name = cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));

                    String number = cursor.getString(
                            cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    cursor.close();

                    // 🔹 Open second page
                    Intent intent = new Intent(MainActivity.this, ContactDetailsActivity.class);
                    intent.putExtra("name", name);
                    intent.putExtra("number", number);
                    startActivity(intent);
                }
            }
        }
    }
}