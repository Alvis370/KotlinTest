package com.illuminator.kotlintest.webservice.api;

import com.illuminator.kotlintest.webservice.request.SessionCreateRequest;
import com.illuminator.kotlintest.webservice.response.SessionCreateResponse;
import com.illuminator.kotlintest.webservice.ApiBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by LiGe
 * Date: 2019/8/22
 */
public interface SessionApi {

    class Builder{
        private final ApiBuilder apiBuilder;

        public Builder(ApiBuilder apiBuilder){this.apiBuilder = apiBuilder;}

        public SessionApi build(){
            return apiBuilder
                    .setConnectionTimeout(ApiBuilder.GLOBAL_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                    .setReadTimeout(ApiBuilder.GLOBAL_READ_TIMEOUT, TimeUnit.SECONDS)
                    .setWriteTimeout(ApiBuilder.GLOBAL_WRITE_TIMEOUT, TimeUnit.SECONDS)
                    .useRxJava2()
                    .useGsonSerializer()
                    .build(SessionApi.class);
        }
    }

    @POST("/v1/session")
    Single<SessionCreateResponse> createSession (@Header("token") String authToken,
                                                @Header("date") String date,
                                                @Body SessionCreateRequest request);

    @GET("/v1/session/token")
    Single<SessionCreateResponse> sessionToken (@Header("Authorization") String sessionId);

    @Headers({"Accept: application/json", "Content-Type: application/json"})
    @DELETE
    Single<Response<Void>> deleteSessionToken (@Header("Authorization") String sessionId);
}
