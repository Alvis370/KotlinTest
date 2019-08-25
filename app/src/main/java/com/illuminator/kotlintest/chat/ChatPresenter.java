package com.illuminator.kotlintest.chat;

/**
 * Created by Android Studio.
 * User: LiGe
 * Date: 2019/8/21
 * Time: 18:27
 */
public class ChatPresenter implements ChatContract.Presenter {

    private ChatContract.View chatView;

    public ChatPresenter(ChatContract.View chatView){
        this.chatView = chatView;
    }

    @Override
    public void sendMessage(String message) {
        if(message != null && !message.isEmpty()){
            chatView.addMessage(message);
        }
    }

    @Override
    public void messageInputChanged(String messageInput) {
        if(messageInput == null || messageInput.isEmpty()){
            chatView.disableSendButton();
        }else{
            chatView.enableSendButton();
        }
    }
}
