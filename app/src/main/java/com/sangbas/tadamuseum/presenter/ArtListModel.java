package com.sangbas.tadamuseum.presenter;

import android.util.Log;

import com.sangbas.tadamuseum.api.ApiClient;
import com.sangbas.tadamuseum.api.RijksmuseumService;
import com.sangbas.tadamuseum.model.ArtObject;
import com.sangbas.tadamuseum.model.Arts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtListModel implements ArtListContract.Model {

    private final String TAG = "ArtListModel";
    /**
     * This function will fetch movies data
     * @param onFinishedListener
     * @param pageNo : Which page to load.
     */
    @Override
    public void getArtList(final OnFinishedListener onFinishedListener) {

        RijksmuseumService apiService =
                ApiClient.getClient().create(RijksmuseumService.class);

        Call<Arts> call = apiService.listArts();
        call.enqueue(new Callback<Arts>() {
            @Override
            public void onResponse(Call<Arts> call, Response<Arts> response) {
                List<ArtObject> arts = response.body().getArtObjects();
                Log.d(TAG, "Number of arts received: " + arts.size());
                onFinishedListener.onFinished(arts);
            }

            @Override
            public void onFailure(Call<Arts> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                onFinishedListener.onFailure(t);
            }
        });
    }
}
