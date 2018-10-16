package com.sangbas.tadamuseum.api;

import com.sangbas.tadamuseum.model.Arts;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RijksmuseumService {

    @GET("/api/en/collection?key=end5gbe5&format=json")
    Call<Arts> listArts();
}
