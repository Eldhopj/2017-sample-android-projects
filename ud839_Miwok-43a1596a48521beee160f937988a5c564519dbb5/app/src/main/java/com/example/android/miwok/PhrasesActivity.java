/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mMediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
       final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus",R.raw.phrase_where_are_you_going));
        words.add(new Word("What is your name?", "tinnә oyaase'nә",R.raw.phrase_what_is_your_name));
//        words.add(new Word("My name is...", "oyaaset..."));
//        words.add(new Word("How are you feeling?", "michәksәs?"));
//        words.add(new Word("I’m feeling good.", "kuchi achit"));
//        words.add(new Word("Are you coming?", "әәnәs'aa?"));
//        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
//        words.add(new Word("I’m coming.", "әәnәm"));
//        words.add(new Word("Let’s go.", "yoowutis"));
//        words.add(new Word("Come here.", "әnni'nem"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word audio = words.get(position); //To get position
                 mMediaPlayer = MediaPlayer.create(PhrasesActivity.this,audio.getAdudioId()); // gets audio id
                mMediaPlayer.start();
                mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                    /**
                     * Clean up the media player by releasing its resources.
                     */
                    private void releaseMediaPlayer() {
                        // If the media player is not null, then it may be currently playing a sound.
                        if (mMediaPlayer != null) {
                            // Regardless of the current state of the media player, release its resources
                            // because we no longer need it.
                            mMediaPlayer.release();

                            // Set the media player back to null. For our code, we've decided that
                            // setting the media player to null is an easy way to tell that the media player
                            // is not configured to play an audio file at the moment.
                            mMediaPlayer = null;
                        }
                    }
                });
            }
        });
    }
}
