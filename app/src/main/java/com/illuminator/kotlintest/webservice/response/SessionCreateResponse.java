package com.illuminator.kotlintest.webservice.response;

import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public class SessionCreateResponse {

    @SerializedName("data") private Data data;

    public SessionCreateResponse(Data data){this.data = data;}

    @Nullable
    public String getSessionId(){
        return data != null ? data.sessionId : null;
    }

    public static class Data{
        @SerializedName("session_id") private String sessionId;

        public Data(String sessionId){this.sessionId = sessionId;}
    }
}
