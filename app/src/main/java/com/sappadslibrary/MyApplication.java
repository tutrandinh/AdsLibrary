package com.sappadslibrary;

import com.sapp.ads.util.AppOpenManager;
import com.sapp.ads.util.AdsApplication;

import java.util.List;

public class MyApplication extends AdsApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        AppOpenManager.getInstance().disableAppResumeWithActivity(Splash.class);
    }

    @Override
    public boolean enableAdsResume() {
        return true;
    }

    @Override
    public List<String> getListTestDeviceId() {
        return null;
    }

    @Override
    public String getResumeAdId() {
        return getString(R.string.admod_app_open_ad_id);
    }

    @Override
    public Boolean buildDebug() {
        return true;
    }
}
