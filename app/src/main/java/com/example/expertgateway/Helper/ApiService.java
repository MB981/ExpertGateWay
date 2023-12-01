package com.example.expertgateway.Helper;



import com.example.expertgateway.Model.HomeModel;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.Call;
public interface ApiService {
    @GET("Sections/getAllSectionsDetails?countryId=1&isMobile=true")
    Call<HomeModel> getHome();
}
