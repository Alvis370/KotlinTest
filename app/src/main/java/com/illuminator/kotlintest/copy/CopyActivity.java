package com.illuminator.kotlintest.copy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

import com.illuminator.kotlintest.R;
import com.illuminator.kotlintest.utils.MyDialogView;
import com.illuminator.kotlintest.utils.MyPopupView;

/**
 * added to git
 */
public class CopyActivity extends AppCompatActivity implements CopyContract.CopyView, MyDialogView.OnCancelListener{

    private CopyPresenter copyPresenter;

    private Button button1;
    private MyDialogView myDialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copy);

        button1 = findViewById(R.id.button);

        copyPresenter = new CopyPresenter(this);

        initView();
    }

    private void initView(){
        button1.setOnClickListener((v) -> {
            copyPresenter.onSignInButtonClicked();
        });
    }

    @Override
    public void showSignInAction() {
//        MyPopupView myPopupView = new MyPopupView(this, button1);
//        myPopupView.show();

        myDialogView = new MyDialogView(this);
        myDialogView.show(this, "whatever", "message", true, this);
        //this is a test
    }

    @Override
    public void showSignUpAction() {

    }


    @Override
    public void onCancel(DialogInterface dialog) {
        myDialogView.dismiss();
    }
}
