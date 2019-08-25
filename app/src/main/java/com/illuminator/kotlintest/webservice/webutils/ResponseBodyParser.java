package com.illuminator.kotlintest.webservice.webutils;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.IOException;

import okhttp3.ResponseBody;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public final class ResponseBodyParser
{
    public static <T> T parseRawResponse(@Nullable ResponseBody responseBody, Class<T> classType){
        if(responseBody == null){
            return null;
        }

        Gson gson = new Gson();
        TypeAdapter<T> adapter = gson.getAdapter(classType);
        JsonReader jsonReader = gson.newJsonReader(responseBody.charStream());

        try{
            return adapter.read(jsonReader);
        }catch(IOException e){
            return null;
        }finally {
            responseBody.close();
        }
    }
}
