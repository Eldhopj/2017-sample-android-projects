package com.example.android.flavor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecuclerAdapter extends RecyclerView.Adapter<RecuclerAdapter.MyViewHolder> {
    Context ctx;

    public RecuclerAdapter(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(ctx).inflate(R.layout.list_item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
//            name = (TextView)itemView.findViewById(R.id.);
        }
    }
}
