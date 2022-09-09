package com.sappadslibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;

import com.sapp.ads.applovin.AppLovin;
import com.sapp.ads.applovin.AppLovinCallback;
import com.sapp.ads.billing.AppPurchase;
import com.sapp.ads.callback.BillingListener;
import com.sappadslibrary.applovin.MainApplovinActivity;
import com.applovin.mediation.MaxError;

import java.util.ArrayList;
import java.util.List;

public class Splash extends AppCompatActivity {
    private static final String TAG = "SplashActivity";
    public static String PRODUCT_ID_MONTH = "android.test.purchased";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        String android_id = Settings.Secure.getString(this.getContentResolver(),
                Settings.Secure.ANDROID_ID);
       // Log.e("xxx",android_id);
        // Admod
        AppPurchase.getInstance().setBillingListener(new BillingListener() {
            @Override
            public void onInitBillingListener(int code) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        AppLovin.getInstance().loadSplashInterstitialAds(Splash.this, getString(R.string.applovin_test_banner),25000,5000, new AppLovinCallback(){
                            @Override
                            public void onAdClosed() {
                                startActivity(new Intent(Splash.this, MainApplovinActivity.class));
                                finish();
                            }

                            @Override
                            public void onAdFailedToLoad(MaxError i) {
                                super.onAdFailedToLoad(i);
                                startActivity(new Intent(Splash.this,MainApplovinActivity.class));
                                finish();
                            }
                        });
                    }
                });
            }
        }, 5000);

        initBilling();
    }

    private void initBilling() {
        List<String> listINAPId = new ArrayList<>();
        listINAPId.add(PRODUCT_ID_MONTH);
        List<String> listSubsId = new ArrayList<>();
        AppPurchase.getInstance().initBilling(getApplication(),listINAPId,listSubsId);

    }
}