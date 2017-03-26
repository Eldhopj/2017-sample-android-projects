package com.example.eldho.androidclass17march;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView username;
    EditText useredit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button) findViewById(R.id.button);
        username =(TextView) findViewById( R.id.username);
        useredit = (EditText) findViewById(R.id.edituser);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                String temp = useredit.getText().toString();
                i.putExtra("data",temp);
                startActivity(i);

            }
        });
    }
}
