package com.example.eldho.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        recyclerView = (RecyclerView)findViewById(R.id.recyclerlist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this,generics);
        recyclerView.setAdapter(adapter);


    }

}
