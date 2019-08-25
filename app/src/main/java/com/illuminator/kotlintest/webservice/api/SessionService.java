package com.illuminator.kotlintest.webservice.api;

import com.illuminator.kotlintest.webservice.request.SessionCreateRequest;
import com.illuminator.kotlintest.webservice.response.ErrorResponse;
import com.illuminator.kotlintest.webservice.response.SessionCreateResponse;
import com.illuminator.kotlintest.webservice.webutils.ResponseBodyParser;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import retrofit2.HttpException;
import retrofit2.Response;

import static com.illuminator.kotlintest.webservice.webutils.ResponseBodyParser.parseRawResponse;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public class SessionService {

    private static final String SESSION_ID_PREFIX = "SID ";
    private static final String PROSPECT_CUSTOMER_AUT_055 = "AUTO055";
    private static final String SESSION_AUT_056 = "AUTO056";

    private SessionApi api;
//    private AuthCodeVerifier authCodeVerifier;
    private String authId;

    public SessionService(SessionApi api, String authId){
        this.api = api;
        this.authId = authId;
    }

    public Single<SessionCreateResponse> createSession(String authToken, String date){
        SessionCreateRequest request =
                new SessionCreateRequest.Builder()
                .code(date)
                .codeVerifier(authToken)
                .build();

        return api.createSession(authToken, date, request).onErrorResumeNext(this::checkErrors);
    }

    public Single<SessionCreateResponse> getSessionToken(String sessionId){
        return api.sessionToken(sessionId).onErrorResumeNext(this::checkErrors);
    }

    public Single<Response<Void>> deleteSession(String sessionId){
        return api.deleteSessionToken(sessionId)
                .flatMap(response -> {
                    if(response.isSuccessful()){
                        return Single.just(response);
                    }else{
                        return Single.error(new HttpException(response));
                    }
                })
                .onErrorResumeNext(this::checkErrors);
    }

    private SingleSource checkErrors(Throwable e){
        if(e instanceof HttpException){
            HttpException exception = (HttpException) e;
            ErrorResponse errorResponse = parseRawResponse(exception.response().errorBody(), ErrorResponse.class);
            Exception parsedError = parseError(errorResponse);
            return Single.error(parsedError);
        }else{
            return Single.error(e);
        }
    }

    private Exception parseError(ErrorResponse errorResponse){
        Exception exception = null;

        //TODO
        /*if(errorResponse == null || errorResponse.getErrors() == null || errorResponse.getErrors().isEmpty()){
            return new GenericAuthException("", null, null);
        }

        String errorCode = errorResponse.getDictionaryError().getCode();
        //TODO

        if(SESSION_AUT_056.endsWith(errorCode)){
            exception = new SessionAuthException();
        }else if(PROSPECT_CUSTOMER_AUT_055.equals(errorCode)){

        }

        if(exception == null){
            if(mar){

            }
        }
        */
        return exception;
    }
}
