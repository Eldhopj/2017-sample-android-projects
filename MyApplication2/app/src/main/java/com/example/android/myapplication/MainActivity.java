package com.example.android.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tv1;
    Button submit;
    EditText ed;
    TextView display;
    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView) findViewById(R.id.maintext);
        ed = (EditText) findViewById(R.id.editText);
        submit = (Button) findViewById(R.id.buttonmain);
        submit.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        String displays = ed.getText().toString();
        display.setText(displays);
    }
}
