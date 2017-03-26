package com.example.android.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    private EditText ext1,ext2;
    private TextView txt1;
    private Button btn1;

    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ext1= (EditText) findViewById(R.id.ext1);
        ext2= (EditText) findViewById(R.id.ext2);
        txt1= (TextView) findViewById(R.id.txt1);
        btn1= (Button) findViewById(R.id.btn1);
        firebaseAuth=firebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()!=null)
        {
            finish();
            startActivity(new Intent(getApplicationContext(),ProfileActivity.class));


        }



    }

    @Override
    public void onClick(View v) {

    }
}

