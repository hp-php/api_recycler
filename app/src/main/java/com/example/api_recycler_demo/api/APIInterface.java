package com.example.api_recycler_demo.api;


import com.example.api_recycler_demo.model.GetAllDisease_RootModel;
import com.example.api_recycler_demo.model.GetAllHabits_RootModel;
import com.example.api_recycler_demo.model.GetAllRiskArea_RootModel;
import com.example.api_recycler_demo.model.ListPackage_Root_Model;
import com.example.api_recycler_demo.model.ListTest_RootModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface APIInterface {

    @GET("getAllRiskAreas")
    @Headers({"Accept: application/json"})
    Call<GetAllRiskArea_RootModel> riskArea(@Header("Authorization") String token);

    @GET("getAllHabits")
    @Headers({"Accept: application/json"})
    Call<GetAllHabits_RootModel> habits(@Header("Authorization") String token);

    @POST("tests")
    @Headers({"Accept: application/json"})
    Call<ListTest_RootModel> listTest (@Header("Authorization") String token);

    @POST("packages")
    @Headers({"Accept: application/json"})
    Call<ListPackage_Root_Model> listPackage(@Header("Authorization") String token);

    @GET("getAllDiseases")
    @Headers({"Accept: application/json"})
    Call<GetAllDisease_RootModel> getDisease(@Header("Authorization") String token);





}
