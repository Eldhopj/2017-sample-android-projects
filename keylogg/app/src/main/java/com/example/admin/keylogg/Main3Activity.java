package com.example.admin.keylogg;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
String response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Intent i=getIntent();
        response=i.getStringExtra("KB");
        StringBuilder bl = new StringBuilder(response);
        try {
            Button b1 = (Button) findViewById(R.id.b1);
            b1.setText(bl.toString().subSequence(0,1));
       b1=(Button)findViewById(R.id.b2);
        b1.setText(response.subSequence(1,2));
        b1=(Button)findViewById(R.id.b3);
        b1.setText(response.subSequence(2,3));
        b1=(Button)findViewById(R.id.b4);
        b1.setText(response.subSequence(3,4));
        b1=(Button)findViewById(R.id.b5);
        b1.setText(response.subSequence(4,5));
        b1=(Button)findViewById(R.id.b6);
        b1.setText(response.subSequence(5,6));
        b1=(Button)findViewById(R.id.b7);
        b1.setText(response.subSequence(6,7));
        b1=(Button)findViewById(R.id.b8);
        b1.setText(response.subSequence(7,8));
        b1=(Button)findViewById(R.id.b9);
        b1.setText(response.subSequence(8,9));
        b1=(Button)findViewById(R.id.b10);
        b1.setText(response.subSequence(9,10));
        }catch (Exception e){

            Button b1=(Button)findViewById(R.id.b1);
            b1.setText(e.toString());

        }
    }

}
