package com.example.android.mediaplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button play;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(this,R.raw.test);
        play = (Button)  findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Context context = getApplicationContext();
                        CharSequence text = "Hello toast!";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                });

            }
        });

        Button pause = (Button) findViewById(R.id.pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

    }

    }


