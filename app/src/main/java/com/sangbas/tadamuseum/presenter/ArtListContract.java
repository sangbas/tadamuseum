package com.sangbas.tadamuseum.presenter;

import com.sangbas.tadamuseum.model.ArtObject;
import com.sangbas.tadamuseum.model.Arts;

import java.util.List;

public interface ArtListContract {


    interface Model {

        interface OnFinishedListener {
            void onFinished(List<ArtObject> movieArrayList);
            void onFailure(Throwable t);
        }
        void getArtList(OnFinishedListener onFinishedListener);
    }

    interface View {
        void showProgress();
        void hideProgress();
        void setDataToRecyclerView(List<ArtObject> movieArrayList);
        void onResponseFailure(Throwable throwable);
    }

    interface Presenter {
        void onDestroy();
        void getMoreData(int pageNo);
        void requestDataFromServer();
    }

}
