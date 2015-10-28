package com.ty.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchHelper.Callback;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ty.demo.R;
import com.ty.demo.inface.ItemTouchHelperAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2015/10/15.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements ItemTouchHelperAdapter {

    private Context mContext;
    private List<String> mData;

    private List<Integer> mHeight;

    public RecyclerViewAdapter(Context c, List<String> d) {
        this.mContext = c;
        this.mData = d;
        mHeight=new ArrayList<Integer>();

        for (int i = 0; i < mData.size(); i++) {
            mHeight.add((50+(int) (Math.random()*300)));
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Log.v("TAG","onCreateViewHolder");
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recycleview, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.v("TAG","onBindViewHolder");
        ViewGroup.LayoutParams layoutParams = holder.itemRecycleviewText.getLayoutParams();

        layoutParams.height = mHeight.get(position);
        holder.itemRecycleviewText.setLayoutParams(layoutParams);

        holder.itemRecycleviewText.setText(mData.get(position));


    }


    @Override
    public int getItemCount() {

        Log.v("TAG","getItemCount");
        return mData.size();
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

        Collections.swap(mData,fromPosition,toPosition);

        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

        mData.remove(position);
        notifyItemRemoved(position);
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_recycleview_text)
        public TextView itemRecycleviewText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
//            itemRecycleviewText= (TextView) itemView.findViewById(R.id.item_recycleview_text);
        }

    }
}
