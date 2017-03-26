package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        Log.i("EnterpriseActivity.java", "Captain's Log, Stardate 43125.8. We have entered a spectacular binary star system in the Kavis Alpha sector on a most critical mission of astrophysical research.");
        TextView textViewItem1 = (TextView) findViewById(R.id.menu_item_1);
        String menuItem1 =textViewItem1.getText().toString();
        Log.v ("MainActivity",menuItem1);

        // Find second menu item TextView and print the text to the logs

        // Find third menu item TextView and print the text to the logs

    }
}