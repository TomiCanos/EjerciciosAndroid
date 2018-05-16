package com.trabajo_integrador.xilften.dao;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServiceSerie {

    @GET("/3/tv/on_the_air")
    Call<ContenedorDeSeries> getTVOnTheAir(@Query("api_key") String apiKey);

}
