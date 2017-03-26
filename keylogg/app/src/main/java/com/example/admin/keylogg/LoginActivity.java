package com.example.admin.keylogg;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    String contents;
    Button mEmailSignInButton;
    TextView tv;
    String pwd;
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.


        mPasswordView = (EditText) findViewById(R.id.password);
        tv = (TextView) findViewById(R.id.tv);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
        Intent i = getIntent();
        contents = i.getStringExtra("QR");

    }

    public void attemptLogin() {
        tv.setTextColor(Color.RED);
        tv.setText("Please wait...");
        connect();
    }

    public void connect() {
        String url = "http://192.168.132.1:8080/keylogger/get_con_first.php";
        pwd = mPasswordView.getText().toString();
        // Request a string response
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {


                        if (response.contains("0")) {
                            tv.setTextColor(Color.RED);
                            tv.setText("Invalid Password!");
                        } else {
                            tv.setTextColor(Color.GREEN);
                            tv.setText("Login Success!");
                        }

                    }
                }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                // Error handling
                System.out.println("Something went wrong!");
                error.printStackTrace();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                String str = contents;
                params.put("ctext", str);
                params.put("pwd", pwd);
                // params.put("email",str[0]);
                return params;
            }

        };


// Add the request to the queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}


