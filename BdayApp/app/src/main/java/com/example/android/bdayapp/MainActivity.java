package com.example.android.bdayapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et;
    TextView tv;
    Button bt;
    EditText et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.sender); //EditText is defined as edittext in xml
        et2 = (EditText) findViewById(R.id.reciver);
        tv = (TextView) findViewById(R.id.display); //TextView is defined as textview in xml
        bt = (Button) findViewById(R.id.submit); //Button is defined as button in xml

        //When button is clicked
        bt.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String txt = et.getText().toString();
                String txt2 = et2.getText().toString();         //Get txt from et when button is clicked
                tv.setText(txt + txt2); //Set text extracted from et in tv

            }
        });
    }

}

