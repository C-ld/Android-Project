package com.example.day2.myRecycler;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.day2.R;

import java.util.List;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<TestData>mList;
    private IOnItemClickListener mItemClickListener;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView hot;
        public ViewHolder(View view){
            super(view);
            title = (TextView) view.findViewById(R.id.item_title);
            hot = (TextView) view.findViewById(R.id.item_hot);
        }
    }

    public MyAdapter(List<TestData>otherList){
        mList = otherList;
    }
    public interface IOnItemClickListener {

        void onItemCLick(int position, TestData data);

        void onItemLongCLick(int position, TestData data);
    }

    public void setOnItemClickListener(IOnItemClickListener listener) {
        mItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int pos){
        TestData td = mList.get(pos);
        holder.title.setText(td.title);
        holder.hot.setText(td.hot);
    }

    @Override
    public int getItemCount(){
        return mList.size();
    }
}
