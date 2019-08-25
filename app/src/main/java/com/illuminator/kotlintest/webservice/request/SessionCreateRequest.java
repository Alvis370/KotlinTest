package com.illuminator.kotlintest.webservice.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public class SessionCreateRequest {

    @SerializedName("code") private String code;
    @SerializedName("code_verifier") private String codeVerifier;

    private SessionCreateRequest(String code, String codeVerifier){
        this.code = code;
        this.codeVerifier = codeVerifier;
    }

    public String getCode() {
        return code;
    }

    public String getCodeVerifier() {
        return codeVerifier;
    }

    public static class Builder{

        private String code;
        private String codeVerifier;

        public Builder code(String code){
            this.code = code;
            return this;
        }

        public Builder codeVerifier(String codeVerifier){
            this.codeVerifier = codeVerifier;
            return this;
        }

        public SessionCreateRequest build(){
            return new SessionCreateRequest(code, codeVerifier);
        }
    }
}
