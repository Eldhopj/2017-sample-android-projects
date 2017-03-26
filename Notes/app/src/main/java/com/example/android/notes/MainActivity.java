package com.example.android.notes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText addnote;
    ImageButton addButton;
    ListView notelist;
    List <String> lists = new ArrayList<>();

    // Used to load the 'native-lib' library on application startup.
//    static {
//        System.loadLibrary("native-lib");
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addnote = (EditText) findViewById(R.id.addnote);
        addButton = (ImageButton) findViewById(R.id.addButton);
        notelist = (ListView) findViewById(R.id.notelist);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,lists);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lists.add(addnote.getText().toString());
                adapter.notifyDataSetChanged();
                addnote.setText("");
            }
        });
    }
}
//        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(stringFromJNI());
//    }
//
//    /**
//     * A native method that is implemented by the 'native-lib' native library,
//     * which is packaged with this application.
//     */
//    public native String stringFromJNI();
//}