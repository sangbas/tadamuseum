package com.sangbas.tadamuseum.presenter;

import com.sangbas.tadamuseum.model.ArtObject;

import java.util.List;

public class ArtListPresenter implements ArtListContract.Presenter, ArtListContract.Model.OnFinishedListener {

    private ArtListContract.Model artListModel;
    private ArtListContract.View artListView;

    public ArtListPresenter(ArtListContract.View artListView) {
        this.artListView = artListView;
        artListModel = new ArtListModel();
    }

    @Override
    public void onFinished(List<ArtObject> artArrayList) {
        artListView.setDataToRecyclerView(artArrayList);
        if(artListView != null) {
            artListView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        artListView.onResponseFailure(t);
        if(artListView != null) {
            artListView.hideProgress();
        }
    }

    @Override
    public void onDestroy() {
        this.artListModel = null;
    }

    @Override
    public void getMoreData(int pageNo) {

    }

    @Override
    public void requestDataFromServer() {
        if(artListView != null) {
            artListView.showProgress();
        }
        artListModel.getArtList(this);
    }
}
