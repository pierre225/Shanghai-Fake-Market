package com.perso.pierre.shanghaifakemarket;

import android.app.Application;

import com.crashlytics.android.answers.Answers;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Pithou on 20/03/2016.
 */
public class FakeMarketApplication extends Application{


    @Override
    public void onCreate() {
        super.onCreate();

        Fabric.with(this, new Answers());


    }
}
