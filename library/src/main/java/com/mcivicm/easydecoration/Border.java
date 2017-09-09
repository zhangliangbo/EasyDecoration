package com.mcivicm.easydecoration;

import android.graphics.Color;

/**
 * 每个Item的边缘，a border, with thickness, color and left/right side padding
 */

public class Border {

    private int color;
    private int thickness;//边缘的厚度
    private int paddingLeft;//边缘的左间距
    private int paddingRight;//边缘的右间距

    public Border() {
        color = Color.TRANSPARENT;
        thickness = 0;
        paddingLeft = 0;
        paddingRight = 0;
    }

    public void reset() {
        color = Color.TRANSPARENT;
        thickness = 0;
        paddingLeft = 0;
        paddingRight = 0;
    }

    public int getThickness() {
        return thickness;
    }

    public Border setThickness(float thickness) {
        this.thickness = Math.round(thickness);//减小失真
        return this;
    }

    public Border setThickness(int thickness) {
        this.thickness = thickness;
        return this;
    }

    public int getPaddingLeft() {
        return paddingLeft;
    }

    public Border setPaddingLeft(float paddingLeft) {
        this.paddingLeft = Math.round(paddingLeft);//减小失真
        return this;
    }

    public Border setPaddingLeft(int paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public int getPaddingRight() {
        return paddingRight;
    }

    public Border setPaddingRight(float paddingRight) {
        this.paddingRight = Math.round(paddingRight);//减小失真
        return this;
    }

    public Border setPaddingRight(int paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Border setColor(int color) {
        this.color = color;
        return this;
    }
}
