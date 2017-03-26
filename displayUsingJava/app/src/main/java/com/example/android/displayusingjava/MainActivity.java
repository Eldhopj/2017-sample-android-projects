package com.example.android.displayusingjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setText("Eldho");
        textview.setTextColor(R.color.colorPrimary);
        setContentView(textview);
    }
}
