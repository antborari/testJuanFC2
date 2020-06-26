package com.example.testjuanfc.chat.retrofit;

import com.example.testjuanfc.chat.data.randomuser.ResultsDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("api/")
    Call<ResultsDTO> getUsers(@Query("results")int numberUsers);

}