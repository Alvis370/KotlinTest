package com.illuminator.kotlintest.webservice.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.HttpException;
import retrofit2.Response;

import static com.illuminator.kotlintest.webservice.webutils.ResponseBodyParser.parseRawResponse;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public class ErrorResponse {

    //TODO 以下引用有错
    @SerializedName("errors") private List<Error> errors;
    @SerializedName("error") private Error dictionaryError;

    public ErrorResponse(List<Error> errors, Error dictionaryError){
        this.errors = errors;
        this.dictionaryError = dictionaryError;
    }

    public List<Error> getErrors() {
        return errors;
    }

    public Error getDictionaryError() {
        return dictionaryError;
    }

    @NonNull
    public boolean hasErrors(){
        return getErrors() != null && !getErrors().isEmpty();
    }

    @Nullable
    public static ErrorResponse getError(Throwable throwable){
        if(throwable instanceof HttpException){
            HttpException httpException = (HttpException) throwable;
            Response<?> response = httpException.response();
            if(response == null || response.errorBody() == null){
                return null;
            }
            return parseRawResponse(response.errorBody(), ErrorResponse.class);
        }else{
            return null;
        }
    }
}
