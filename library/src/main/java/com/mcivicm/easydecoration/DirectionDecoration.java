package com.mcivicm.easydecoration;

import android.graphics.Color;

/**
 * 跟方向相关
 */

public class DirectionDecoration extends BaseDecoration {

    private boolean showFirst = true;
    private boolean showLast = true;
    private int color = Color.TRANSPARENT;
    private float size = 15f;
    private float paddingLeft = 15f;
    private float paddingRight = 15f;
    private float firstPaddingLeft = 0f;
    private float firstPaddingRight = 0f;
    private float lastPaddingLeft = 0f;
    private float lastPaddingRight = 0f;

    public DirectionDecoration setShowFirst(boolean showFirst) {
        this.showFirst = showFirst;
        return this;
    }

    public DirectionDecoration setShowLast(boolean showLast) {
        this.showLast = showLast;
        return this;
    }

    public DirectionDecoration setColor(int color) {
        this.color = color;
        return this;
    }

    public DirectionDecoration setSize(float size) {
        this.size = size;
        return this;
    }

    public DirectionDecoration setPaddingLeft(float paddingLeft) {
        this.paddingLeft = paddingLeft;
        return this;
    }

    public DirectionDecoration setPaddingRight(float paddingRight) {
        this.paddingRight = paddingRight;
        return this;
    }

    public DirectionDecoration setFirstPaddingLeft(float firstPaddingLeft) {
        this.firstPaddingLeft = firstPaddingLeft;
        return this;
    }

    public DirectionDecoration setFirstPaddingRight(float firstPaddingRight) {
        this.firstPaddingRight = firstPaddingRight;
        return this;
    }

    public DirectionDecoration setLastPaddingLeft(float lastPaddingLeft) {
        this.lastPaddingLeft = lastPaddingLeft;
        return this;
    }

    public DirectionDecoration setLastPaddingRight(float lastPaddingRight) {
        this.lastPaddingRight = lastPaddingRight;
        return this;
    }

    public boolean isShowFirst() {
        return showFirst;
    }

    public boolean isShowLast() {
        return showLast;
    }

    public int getColor() {
        return color;
    }

    public float getSize() {
        return size;
    }

    public float getPaddingLeft() {
        return paddingLeft;
    }

    public float getPaddingRight() {
        return paddingRight;
    }

    public float getFirstPaddingLeft() {
        return firstPaddingLeft;
    }

    public float getFirstPaddingRight() {
        return firstPaddingRight;
    }

    public float getLastPaddingLeft() {
        return lastPaddingLeft;
    }

    public float getLastPaddingRight() {
        return lastPaddingRight;
    }
}
