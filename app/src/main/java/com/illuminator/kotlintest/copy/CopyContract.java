package com.illuminator.kotlintest.copy;

/**
 * Created by LiGe
 * Date: 2019/8/24
 */
public class CopyContract {

    interface CopyView{
        void showSignInAction();
        void showSignUpAction();
    }

    interface CopyPresenter{
        void onSignInButtonClicked();
        void onSignUpButtonClicked();
    }
}
