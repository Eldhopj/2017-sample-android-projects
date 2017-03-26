package me.rougarou.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Newactivity extends AppCompatActivity {
TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newactivity);
        tv=(TextView)findViewById(R.id.textView);
        String data = getIntent().getStringExtra("data");
    }
}
