package com.example.eldho.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    List<Generic> lists = new ArrayList(); // declaration of List
    Context context;
        // Getting value from constructors
    public RecyclerViewAdapter(Context context,List<Generic> generic) {
        this.context = context;
        this.lists = generic;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Generic gen = lists.get(position);
        holder.textView1.setText(gen.getText1());
        holder.textView2.setText(gen.getText2());
        holder.textView3.setText(gen.getText3());
        holder.imageView.setImageResource(gen.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
        ImageView imageView;
        public MyViewHolder(View itemView) {

            super(itemView);
            textView1 = (TextView) itemView.findViewById(R.id.text1);
            textView2 = (TextView) itemView.findViewById(R.id.text2);
            textView3 = (TextView) itemView.findViewById(R.id.text3);
            imageView =(ImageView) itemView.findViewById(R.id.list_item_icon);


        }
    }
}
