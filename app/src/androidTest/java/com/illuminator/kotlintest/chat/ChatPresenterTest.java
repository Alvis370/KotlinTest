package com.illuminator.kotlintest.chat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

/**
 * Created by Android Studio.
 * User: LiGe
 * Date: 2019/8/21
 * Time: 18:23
 */
public class ChatPresenterTest {
    private ChatContract.Presenter chatPresenter;

    @Mock
    private ChatContract.View chatView;

    private static final String MESSAGE = "This is a normal message.";


    @Before
    public void setUp(){
        //where you initialize all your objects with values
        MockitoAnnotations.initMocks(this);
        chatPresenter = new ChatPresenter(chatView);
    }

    @Test
    public void sendMessageNullStringSent(){
        chatPresenter.sendMessage(null);
        verify(chatView, never()).addMessage(anyString());
    }

    @Test
    public void sendMessageEmptyStringSent(){
        chatPresenter.sendMessage("");
        verify(chatView, never()).addMessage(anyString());
    }

    @Test
    public void sendMessageStringSent(){
        chatPresenter.sendMessage(MESSAGE);
        verify(chatView).addMessage(MESSAGE);
    }

    @Test
    public void messageInputChangedNullStringAndSendButtonDisabled(){
        chatPresenter.messageInputChanged(null);
        verify(chatView).disableSendButton();
    }

    @Test
    public void messageInputChangedEmptyStringAndSendButtonDisabled(){
        chatPresenter.messageInputChanged("");
        verify(chatView).disableSendButton();
    }

    @Test
    public void messageInputChangedStringAndSendButtonEnabled(){
        chatPresenter.messageInputChanged(MESSAGE);
        verify(chatView).enableSendButton();
    }
}
