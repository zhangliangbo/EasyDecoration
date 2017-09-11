package com.mcivicm.easydecoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 基础装饰类，the basic logic of drawing itemDecoration
 */

public class BaseDecoration extends RecyclerView.ItemDecoration {
    private Paint paint = new Paint();
    private ItemBorder itemBorder = new ItemBorder();//避免new太多对象
    private RectF rectF = new RectF();//避免new太多对象

    public BaseDecoration() {
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);//子View
            itemBorder.reset();//reset itemBorder
            getItemBorder(parent.getChildAdapterPosition(view), itemBorder, state.getItemCount());//给ItemBorder赋值
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            //左边缘-leftBorder
            rectF.set(view.getLeft() - layoutParams.leftMargin - itemBorder.getLeftBorder().getThickness(),
                    view.getTop() - layoutParams.topMargin - itemBorder.getTopBorder().getThickness() + itemBorder.getLeftBorder().getPaddingRight(),
                    view.getLeft() - layoutParams.leftMargin,
                    view.getBottom() + layoutParams.bottomMargin + itemBorder.getBottomBorder().getThickness() - itemBorder.getLeftBorder().getPaddingLeft());
            paint.setColor(itemBorder.getLeftBorder().getColor());
            c.drawRect(rectF, paint);
            //上边缘-topBorder
            rectF.set(view.getLeft() - layoutParams.leftMargin - itemBorder.getLeftBorder().getThickness() + itemBorder.getTopBorder().getPaddingLeft(),
                    view.getTop() - layoutParams.topMargin - itemBorder.getTopBorder().getThickness(),
                    view.getRight() + layoutParams.rightMargin + itemBorder.getRightBorder().getThickness() - itemBorder.getTopBorder().getPaddingRight(),
                    view.getTop() - layoutParams.topMargin);
            paint.setColor(itemBorder.getTopBorder().getColor());
            c.drawRect(rectF, paint);
            //右边缘-rightBorder
            rectF.set(view.getRight() + layoutParams.rightMargin,
                    view.getTop() - layoutParams.topMargin - itemBorder.getTopBorder().getThickness() + itemBorder.getRightBorder().getPaddingLeft(),
                    view.getRight() + layoutParams.rightMargin + itemBorder.getRightBorder().getThickness(),
                    view.getBottom() + layoutParams.bottomMargin + itemBorder.getBottomBorder().getThickness() - itemBorder.getRightBorder().getPaddingRight());
            paint.setColor(itemBorder.getRightBorder().getColor());
            c.drawRect(rectF, paint);
            //下边缘-bottomBorder
            rectF.set(view.getLeft() - layoutParams.leftMargin - itemBorder.getLeftBorder().getThickness() + itemBorder.getBottomBorder().getPaddingLeft(),
                    view.getBottom() + layoutParams.bottomMargin,
                    view.getRight() + layoutParams.rightMargin + itemBorder.getRightBorder().getThickness() - itemBorder.getBottomBorder().getPaddingRight(),
                    view.getBottom() + +layoutParams.bottomMargin + itemBorder.getBottomBorder().getThickness());
            paint.setColor(itemBorder.getBottomBorder().getColor());
            c.drawRect(rectF, paint);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        itemBorder.reset();//reset itemBorder
        getItemBorder(parent.getChildAdapterPosition(view), itemBorder, state.getItemCount());//给ItemBorder赋值
        outRect.set(itemBorder.getLeftBorder().getThickness(),
                itemBorder.getTopBorder().getThickness(),
                itemBorder.getRightBorder().getThickness(),
                itemBorder.getBottomBorder().getThickness());
    }

    /**
     * @param position   当前视图的位置
     * @param itemBorder 当前itemView的边缘
     * @param count      元素总数
     */
    public void getItemBorder(int position, ItemBorder itemBorder, int count) {

    }
}
