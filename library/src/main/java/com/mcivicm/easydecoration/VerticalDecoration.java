package com.mcivicm.easydecoration;

/**
 * 垂直
 */

public class VerticalDecoration extends DirectionDecoration {
    @Override
    public void getItemBorder(int position, ItemBorder itemBorder, int count) {
        if (position == 0) {
            if (isShowFirst()) {
                itemBorder.getLeftBorder().setColor(getColor()).setThickness(getSize()).setPaddingLeft(getFirstPaddingLeft()).setPaddingRight(getFirstPaddingRight());
            }
            itemBorder.getRightBorder().setColor(getColor()).setThickness(getSize()).setPaddingLeft(getPaddingLeft()).setPaddingRight(getPaddingRight());
        } else if (position == count - 1) {
            if (isShowLast()) {
                itemBorder.getRightBorder().setColor(getColor()).setThickness(getSize()).setPaddingLeft(getLastPaddingLeft()).setPaddingRight(getLastPaddingRight());
            }
        } else {
            itemBorder.getRightBorder().setColor(getColor()).setThickness(getSize()).setPaddingLeft(getPaddingLeft()).setPaddingRight(getPaddingRight());
        }
    }
}
