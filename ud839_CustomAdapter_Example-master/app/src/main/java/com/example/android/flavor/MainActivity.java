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
package com.example.android.flavor;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an ArrayList of Generic objects
        ArrayList<Generic> generics = new ArrayList<Generic>();
        generics.add(new Generic("Text3","Text1", "Text2", R.drawable.donut));
        generics.add(new Generic("Text3", "Text1", "Text2", R.drawable.eclair));
        generics.add(new Generic("Text3", "Text1","Text2", R.drawable.froyo));
        generics.add(new Generic("Text3", "Text1","Text2", R.drawable.gingerbread));
        generics.add(new Generic("Text3", "Text1","Text2", R.drawable.honeycomb));
        generics.add(new Generic("Text3","Text1", "Text2", R.drawable.icecream));
        generics.add(new Generic("Text3","Text1", "Text2", R.drawable.jellybean));
        generics.add(new Generic("Text3","Text1", "Text2", R.drawable.kitkat));
        generics.add(new Generic("Text3", "Text1","Text2", R.drawable.lollipop));
        generics.add(new Generic("Text3", "Text1","Text2", R.drawable.marshmallow));

        // Create an {@link CustomAdapter}, whose data source is a list of
        // {@link Generic}s. The adapter knows how to create list item views for each item
        // in the list.
        CustomAdapter flavorAdapter = new CustomAdapter(this, generics);

        RecuclerAdapter adapter = new RecuclerAdapter(this);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.listview_flavor);
        listView.setAdapter(flavorAdapter);
    }
}
