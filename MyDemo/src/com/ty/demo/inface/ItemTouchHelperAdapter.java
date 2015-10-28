package com.ty.demo.inface;

/**
 * Created by Administrator on 2015/10/16.
 */
public interface ItemTouchHelperAdapter {

    void onItemMove(int fromPosition,int toPosition);

    void onItemDismiss(int position);
}
