package com.illuminator.kotlintest.utils;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.illuminator.kotlintest.R;

/**
 * Created by LiGe
 * Date: 2019/8/24
 */
public class MyDialogView extends Dialog {

    public MyDialogView(@NonNull Context context) {
        super(context);
    }

    public MyDialogView show(Context context, CharSequence title, CharSequence message,
                                    boolean cancelable, OnCancelListener cancelListener) {
        MyDialogView dialog = new MyDialogView(context);
        dialog.setCancelable(false);
        dialog.setTitle(title);
        dialog.setCancelable(cancelable);
        dialog.setOnCancelListener(cancelListener);

//        FrameLayout.LayoutParams frameLayout = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT,
//                FrameLayout.LayoutParams.WRAP_CONTENT);
        View rootView = LayoutInflater.from(context).inflate(R.layout.waiting_dialog, null);
        TextView messageTextView = rootView.findViewById(R.id.waiting_message);

        if(message == null || TextUtils.isEmpty(message)){
            messageTextView.setVisibility(View.GONE);
        } else{
            messageTextView.setText(message);
        }

        dialog.setContentView(rootView);
        dialog.show();

        return dialog;
    }
}
