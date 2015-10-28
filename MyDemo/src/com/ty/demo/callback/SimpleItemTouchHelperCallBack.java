package com.ty.demo.callback;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.ty.demo.inface.ItemTouchHelperAdapter;

/**
 * Created by Administrator on 2015/10/16.
 */
public class SimpleItemTouchHelperCallBack extends ItemTouchHelper.Callback {


    private final ItemTouchHelperAdapter mAdapter;

    public SimpleItemTouchHelperCallBack(ItemTouchHelperAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }


    @Override
    public boolean isItemViewSwipeEnabled() {
        return true;
    }

    @Override
    public boolean isLongPressDragEnabled() {
        return true;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {

//        int dragFlags=ItemTouchHelper.UP|ItemTouchHelper.DOWN;//listView
//        int swipeFlags=ItemTouchHelper.START|ItemTouchHelper.END;

        //gridView
        int dragFlags=ItemTouchHelper.UP|ItemTouchHelper.DOWN|ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT;
        int swipeFlags=0;

        return makeMovementFlags(dragFlags,swipeFlags);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        mAdapter.onItemMove(viewHolder.getAdapterPosition(),target.getAdapterPosition());

        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        mAdapter.onItemDismiss(viewHolder.getAdapterPosition());
    }
}
