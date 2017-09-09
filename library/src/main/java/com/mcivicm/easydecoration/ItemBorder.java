package com.mcivicm.easydecoration;

/**
 * 每个视图项的四个边，the four borders of itemView
 */

public class ItemBorder {
    //四个边缘
    private Border[] borders = new Border[4];//左上右下

    public ItemBorder() {
        for (int i = 0; i < borders.length; i++) {
            borders[i] = new Border();
        }
    }

    public Border getLeftBorder() {
        return borders[0];
    }

    public Border getTopBorder() {
        return borders[1];
    }

    public Border getRightBorder() {
        return borders[2];
    }

    public Border getBottomBorder() {
        return borders[3];
    }

    public void setBorder(Border left, Border top, Border right, Border bottom) {
        if (left != null) {
            borders[0] = left;
        }
        if (top != null) {
            borders[1] = top;
        }
        if (right != null) {
            borders[2] = right;
        }
        if (bottom != null) {
            borders[3] = bottom;
        }
    }

    public ItemBorder setLeftBorder(Border border) {
        if (border != null) {
            borders[0] = border;
        }
        return this;
    }

    public ItemBorder setTopBorder(Border border) {
        if (border != null) {
            borders[1] = border;
        }
        return this;
    }

    public ItemBorder setRightBorder(Border border) {
        if (border != null) {
            borders[2] = border;
        }
        return this;
    }

    public ItemBorder setBottomBorder(Border border) {
        if (border != null) {
            borders[3] = border;
        }
        return this;
    }

    public ItemBorder setThickness(int left, int top, int right, int bottom) {
        borders[0].setThickness(left);
        borders[1].setThickness(top);
        borders[2].setThickness(right);
        borders[3].setThickness(bottom);
        return this;
    }

    public ItemBorder setLeftBorderPadding(int l, int r) {
        borders[0].setPaddingLeft(l);
        borders[0].setPaddingRight(r);
        return this;
    }


    public ItemBorder setTopBorderPadding(int l, int r) {
        borders[1].setPaddingLeft(l);
        borders[1].setPaddingRight(r);
        return this;
    }

    public ItemBorder setRightBorderPadding(int l, int r) {
        borders[2].setPaddingLeft(l);
        borders[2].setPaddingRight(r);
        return this;
    }

    public ItemBorder setBottomBorderPadding(int l, int r) {
        borders[3].setPaddingLeft(l);
        borders[3].setPaddingRight(r);
        return this;
    }

    public ItemBorder setLeftRightBorderPadding(int l, int r) {
        setLeftBorderPadding(l, r);
        setRightBorderPadding(l, r);
        return this;
    }

    public ItemBorder setTopBottomBorderPadding(int l, int r) {
        setTopBorderPadding(l, r);
        setBottomBorderPadding(l, r);
        return this;
    }

    public ItemBorder setColor(int left, int top, int right, int bottom) {
        getLeftBorder().setColor(left);
        getTopBorder().setColor(top);
        getRightBorder().setColor(right);
        getBottomBorder().setColor(bottom);
        return this;
    }

    public ItemBorder setAllColor(int color) {
        for (Border border : borders) {
            border.setColor(color);
        }
        return this;
    }

    public ItemBorder setAllPaddingLeft(float paddingLeft) {
        for (Border border : borders) {
            border.setPaddingLeft(paddingLeft);
        }
        return this;
    }

    public ItemBorder setAllPaddingRight(float paddingRight) {
        for (Border border : borders) {
            border.setPaddingRight(paddingRight);
        }
        return this;
    }

    public ItemBorder setAllThickness(float thickness) {
        for (Border border : borders) {
            border.setThickness(thickness);
        }
        return this;
    }

    public void reset() {
        for (int i = 0; i < borders.length; i++) {
            borders[i].reset();
        }
    }
}
