package com.illuminator.kotlintest.chat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.illuminator.kotlintest.R;

public class ChatActivity extends AppCompatActivity implements ChatContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat_activity);

    }

    @Override
    public void addMessage(String message) {

    }

    @Override
    public void clearMessageInput() {

    }

    @Override
    public void enableSendButton() {

    }

    @Override
    public void disableSendButton() {

    }
}
