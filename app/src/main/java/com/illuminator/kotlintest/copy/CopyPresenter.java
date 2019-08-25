package com.illuminator.kotlintest.copy;

/**
 * Created by LiGe
 * Date: 2019/8/24
 */
public class CopyPresenter implements CopyContract.CopyPresenter {

    private CopyContract.CopyView copyView;

    public CopyPresenter(CopyContract.CopyView copyView){
        this.copyView = copyView;
    }

    @Override
    public void onSignInButtonClicked() {
        copyView.showSignInAction();
    }

    @Override
    public void onSignUpButtonClicked() {
        copyView.showSignUpAction();
    }
}
