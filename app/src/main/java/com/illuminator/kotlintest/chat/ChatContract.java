package com.illuminator.kotlintest.chat;

/**
 * Created by Android Studio.
 * User: LiGe
 * Date: 2019/8/21
 * Time: 18:13
 */
public class ChatContract {

    interface View{
        void addMessage(String message);

        void clearMessageInput();

        void enableSendButton();

        void disableSendButton();
    }

    interface Presenter{
        void sendMessage(String message);

        void messageInputChanged(String messageInput);
    }
}
