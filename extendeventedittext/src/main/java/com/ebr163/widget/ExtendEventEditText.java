package com.ebr163.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * Created by Ergashev on 24.10.2016.
*/

public class ExtendEventEditText extends EditText {

    private SparseArray<OnDrawableClickListener> drawableListeners;

    public interface OnDrawableClickListener {
        void onClick();
    }

    public interface OnLeftDrawableClickListener extends OnDrawableClickListener {
    }

    public interface OnRightDrawableClickListener extends OnDrawableClickListener {
    }

    public ExtendEventEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        drawableListeners = new SparseArray<>();
    }

    public ExtendEventEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        drawableListeners = new SparseArray<>();
    }

    @Override
    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        super.setCompoundDrawables(left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Rect bounds;
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int actionX = (int) event.getX();
            int actionY = (int) event.getY();

            if (getCompoundDrawables()[0] != null) {
                bounds = getCompoundDrawables()[0].getBounds();
                int extraTapArea = (int) (13 * getResources().getDisplayMetrics().density + 0.5);
                int x = actionX;
                int y = actionY;

                if (!bounds.contains(actionX, actionY)) {
                    x = actionX - extraTapArea;
                    y = actionY - extraTapArea;

                    if (x <= 0)
                        x = actionX;
                    if (y <= 0)
                        y = actionY;
                }

                if (bounds.contains(x, y) && drawableListeners.get(0) != null) {
                    drawableListeners.get(0).onClick();
                    event.setAction(MotionEvent.ACTION_CANCEL);
                    return false;
                }
            }

            if (getCompoundDrawables()[2] != null) {
                bounds = getCompoundDrawables()[2].getBounds();
                int extraTapArea = 13;
                int x = actionX + extraTapArea;
                int y = actionY - extraTapArea;

                x = getWidth() - x;
                if (x <= 0) {
                    x += extraTapArea;
                }
                if (y <= 0)
                    y = actionY;

                if (bounds.contains(x, y) && drawableListeners.get(1) != null) {
                    drawableListeners.get(1).onClick();
                    event.setAction(MotionEvent.ACTION_CANCEL);
                    return false;
                }
                return super.onTouchEvent(event);
            }
        }
        return super.onTouchEvent(event);
    }

    public void setLeftDrawableClickListener(OnDrawableClickListener listener) {
        drawableListeners.put(0, listener);
    }

    public void setRightDrawableClickListener(OnDrawableClickListener listener) {
        drawableListeners.put(1, listener);
    }
}
