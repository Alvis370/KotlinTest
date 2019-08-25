package com.illuminator.kotlintest.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;

import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

import androidx.core.widget.PopupWindowCompat;

import com.illuminator.kotlintest.R;

/**
 * Created by LiGe
 * Date: 2019/8/24
 */
public class MyPopupView extends PopupWindow {

    private MyPopupView myPopupView;
    private Context mContext;
    private Button mButton;

    public MyPopupView(Context context, Button button){
        super(context);
        mContext = context;
        mButton = button;

        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        setOutsideTouchable(true);
        setFocusable(true);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        View contentView = LayoutInflater.from(context).inflate(R.layout.my_popup_view, null, false);

        setContentView(contentView);
    }

    public void show(){
        if(myPopupView == null){
            myPopupView = new MyPopupView(mContext, mButton);
        }
        View contentView = myPopupView.getContentView();
        contentView.measure(makeDropDownMeasureSpec(myPopupView.getWidth()),
                makeDropDownMeasureSpec(myPopupView.getHeight()));

        int offsetX = Math.abs(myPopupView.getContentView().getMeasuredWidth() - mButton.getWidth()) / 2;
        int offsetY = 0;
        PopupWindowCompat.showAsDropDown(myPopupView, mButton, offsetX, offsetY, Gravity.START);
    }

    @SuppressWarnings("ResourceType")
    private static int makeDropDownMeasureSpec(int measureSpec) {
        int mode;
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED;
        } else {
            mode = View.MeasureSpec.EXACTLY;
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode);
    }
}
