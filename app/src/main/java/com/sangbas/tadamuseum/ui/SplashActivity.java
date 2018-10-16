package com.sangbas.tadamuseum.ui;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sangbas.tadamuseum.MyApplication;
import com.sangbas.tadamuseum.R;
import com.sangbas.tadamuseum.util.SessionManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1000;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        session = ((MyApplication) getApplication()).getSession();

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                if(session.isLoggedIn()) {
                    Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
                    SplashActivity.this.startActivity(mainIntent);
                    SplashActivity.this.finish();
                } else {
                    Intent loginIntent = new Intent(SplashActivity.this,LoginActivity.class);
                    SplashActivity.this.startActivity(loginIntent);
                    SplashActivity.this.finish();
                }
            }
        }, SPLASH_TIME_OUT);

    }


}
