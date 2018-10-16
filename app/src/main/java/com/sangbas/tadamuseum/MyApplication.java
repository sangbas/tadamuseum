package com.sangbas.tadamuseum;

import android.app.Application;

import com.sangbas.tadamuseum.util.SessionManager;

public class MyApplication extends Application {

    private SessionManager session;

    @Override
    public void onCreate() {
        super.onCreate();
        session = new SessionManager(getApplicationContext());
    }

    public SessionManager getSession() {
        return session;
    }

}
