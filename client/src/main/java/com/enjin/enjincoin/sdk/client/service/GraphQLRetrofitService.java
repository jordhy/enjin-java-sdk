package com.enjin.enjincoin.sdk.client.service;

import com.google.gson.JsonElement;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GraphQLRetrofitService {

    @GET("graphql")
    Call<JsonElement> query(@Query("query") String query);

}
