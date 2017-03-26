package com.example.eldho.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);

        return new MyViewHolder(view);

    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public MyViewHolder(View itemView) {
            super(itemView);
            TextView textView1 = (TextView) itemView.findViewById(R.id.text1);
            textView1.setText();

        }
    }
}
