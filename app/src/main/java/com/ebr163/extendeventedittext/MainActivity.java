package com.ebr163.extendeventedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.ebr163.widget.ExtendEventEditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ExtendEventEditText eventEditText = (ExtendEventEditText) findViewById(R.id.edit_text);
        eventEditText.setLeftDrawableClickListener(new ExtendEventEditText.OnDrawableClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
        });

        eventEditText.setRightDrawableClickListener(new ExtendEventEditText.OnDrawableClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });

        ExtendEventEditText eventEditText1 = (ExtendEventEditText) findViewById(R.id.edit_text1);
        eventEditText1.setRightDrawableClickListener(new ExtendEventEditText.OnDrawableClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
        });

        ExtendEventEditText eventEditText2 = (ExtendEventEditText) findViewById(R.id.edit_text2);
        eventEditText2.setLeftDrawableClickListener(new ExtendEventEditText.OnDrawableClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "left", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
