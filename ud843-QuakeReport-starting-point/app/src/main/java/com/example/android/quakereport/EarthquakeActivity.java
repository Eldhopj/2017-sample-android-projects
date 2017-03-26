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
package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<Generic> earthquakes = QueryUtils.extractEarthquakes();
//        earthquakes.add(new Generic(7.2,"San Francisco" ,"Feb 2,2016"));
//        earthquakes.add(new Generic(6.1,"London","July 2,2015"));
//        earthquakes.add(new Generic(3.9,"Tokyo","Now 10, 2014"));
//        earthquakes.add("Mexico City");
//        earthquakes.add("Moscow");
//        earthquakes.add("Rio de Janeiro");
//        earthquakes.add("Paris");

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);



        // Create an {@link CustomAdapter}, whose data source is a list of
        // {@link Generic}s. The adapter knows how to create list item views for each item
        // in the list.
        CustomAdapter quakeAdapter = new CustomAdapter(this, earthquakes);

        // Get a reference to the ListView, and attach the adapter to the listView.


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(quakeAdapter);
    }
}
