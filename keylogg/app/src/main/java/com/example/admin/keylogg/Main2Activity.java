package com.example.admin.keylogg;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appdatasearch.GetRecentContextCall;
import com.android.volley.Request.Method;

import java.util.HashMap;
import java.util.Map;


public class Main2Activity extends AppCompatActivity {
    String contents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent i=getIntent();
        contents=i.getStringExtra("QR");
       // Toast toast = Toast.mak0Text(this, "Content:" + contents + " Format:", Toast.LENGTH_LONG)
       // toast.show()
        if(contents.charAt(0)=='2') {
            connect();
        }
      else  if(contents.charAt(0)=='1')
        {
            connect1();
        }
        else
        {
            TextView tv = (TextView) findViewById(R.id.textView2);
            tv.setText("Invalid QR Code");

        }

    }


    public void connect1() {
  Intent i = new Intent(this,LoginActivity.class);
        i.putExtra("QR",contents.substring(1));
        startActivity(i);
        

    }



    public void connect() {
        String url = "http://192.168.132.1:8080/keylogger/d.php";

        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        // Result handlin
                        TextView tv=(TextView)findViewById(R.id.textView2);
                        //tv.setText(response);
                        tv.setText("Please wait!");
                        Intent i=new Intent(Main2Activity.this,Main3Activity.class);
                        i.putExtra("KB",response);
                        startActivity(i);

                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            } }){
                 @Override
                    protected Map<String,String> getParams(){
                    Map<String,String> params = new HashMap<String, String>();
                     String str = contents.substring(1);
                    params.put("ctext",str);
                    // params.put("email",str[0]);
                    return params;
                }

                };


// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
