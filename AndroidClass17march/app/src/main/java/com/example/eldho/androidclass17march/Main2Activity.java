package com.example.eldho.androidclass17march;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView textactivit2 = (TextView) findViewById(R.id.textintenet);
        String content = getIntent().getStringExtra("data");
        textactivit2.setText(content);
    }
}
