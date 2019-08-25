package com.illuminator.kotlintest.copy;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

/**
 * Created by LiGe
 * Date: 2019/8/24
 */
public class copyPresenterTest {

    @Mock
    private CopyContract.CopyView copyView;

    private CopyPresenter copyPresenter;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
        copyPresenter = new CopyPresenter(copyView);
    }

    @Test
    public void onSignInButtonClicked() {
        copyPresenter.onSignInButtonClicked();
        verify(copyView).showSignInAction();
    }

    @Test
    public void onSignUpButtonClicked() {
        copyPresenter.onSignUpButtonClicked();
        verify(copyView).showSignUpAction();
    }
}