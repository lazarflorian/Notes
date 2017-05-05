package com.example.flaviunes.listapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ItemDetails extends AppCompatActivity {

    public static final String NOTE_NAME = "note_name";
    public static final String MY_PREFERENCES = "MyPrefs";
    public static final String NOTE_DETAILS = "note_details";

    SharedPreferences sharedPreferences;

    private EditText editText1, editText2;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_item_details);

        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);

        b1 = (Button) findViewById(R.id.button2);

        sharedPreferences = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

//        Intent intent = getIntent();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nn = editText1.getText().toString();
                String nd = editText2.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putString(NOTE_NAME, nn);
                editor.putString(NOTE_DETAILS, nd);
                editor.apply();
                Toast.makeText(ItemDetails.this, "Succesfully added", Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.putExtra(NOTE_NAME, editText1.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

//    public void saveNote(View view) {
//
//        Context context = getApplicationContext();
//        CharSequence text = "Note saved succesfully!";
//        int duration = Toast.LENGTH_SHORT;
//        Toast toast = Toast.makeText(context, text, duration);
//        toast.show();
//
//        Intent intent = new Intent();
//        intent.putExtra(NOTE_NAME, editText1.getText().toString());
//        setResult(RESULT_OK, intent);
//        finish();
//
//
//    }

    public void cancel(View view) {

        finish();
    }
}
