package com.fengyongge.imageloaderutilssample;

import android.app.Application;
import android.content.res.Configuration;

import androidx.annotation.NonNull;

import com.fengyongge.imageloaderutils.ImageLoaderSdk;
import com.fengyongge.imageloaderutils.constants.ImageLoaderStrategyEnum;

/**
 * @author fengyongge
 * @Description
 */
public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        ImageLoaderSdk.getInstance().trimMemory(this,level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
