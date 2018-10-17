package com.sangbas.tadamuseum;

import android.view.View;

import com.sangbas.tadamuseum.model.ArtObject;
import com.sangbas.tadamuseum.model.WebImage;
import com.sangbas.tadamuseum.presenter.ArtListContract;
import com.sangbas.tadamuseum.presenter.ArtListPresenter;
import com.sangbas.tadamuseum.ui.HomeFragment;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class ArtListPresenterTest {

    @Mock
    private ArtListPresenter presenter;

    @Mock
    private ArtListContract.View view;

    @Mock
    private HomeFragment fragment;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        view = fragment;
        presenter = Mockito.spy(new ArtListPresenter(fragment));
    }

    @Test
    public void handleRequestError() {
        Throwable t = Mockito.mock(Throwable.class);
        presenter.onFailure(t);
        Mockito.verify(view).onResponseFailure(t);
    }

    @Test
    public void setData() {
        List<ArtObject> arts = new ArrayList<>();
        ArtObject art = Mockito.mock(ArtObject.class);
        arts.add(art);
        arts.add(art);
        arts.add(art);

        presenter.onFinished(arts);
        Mockito.verify(view).setDataToRecyclerView(arts);
    }


}
