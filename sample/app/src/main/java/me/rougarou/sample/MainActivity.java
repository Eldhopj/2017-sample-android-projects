package me.rougarou.sample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name;
    TextView text;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        name=(EditText)findViewById(R.id.name);
        text=(TextView) findViewById(R.id.text);
        add=(Button)findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texts=name.getText().toString();
                if(text.length()>0) {
                    Intent newpage =new Intent(MainActivity.this,Newactivity.class);
                    newpage.putExtra ( "TextBox", name.getText().toString() );
                    startActivity(newpage);
                }
                else{
                    Toast.makeText(MainActivity.this,"Enter text..!!",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
