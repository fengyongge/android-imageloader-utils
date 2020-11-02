package com.fengyongge.imageloaderutils;

import android.content.Context;
import android.widget.ImageView;

import com.fengyongge.imageloaderutils.listener.ImageLoaderStrategy;
import com.fengyongge.imageloaderutils.listener.ImageSaveListener;
import com.fengyongge.imageloaderutils.listener.ProgressLoadListener;

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
class GlideImageLoaderStrategy implements ImageLoaderStrategy {
    @Override
    public void loadImage(String url, ImageView imageView) {

    }

    @Override
    public void loadImageWithAppCxt(String url, ImageView imageView) {

    }

    @Override
    public void loadImage(String url, int placeholder, ImageView imageView) {

    }

    @Override
    public void loadImage(Context context, String url, int placeholder, ImageView imageView) {

    }

    @Override
    public void loadCircleImage(String url, int placeholder, ImageView imageView) {

    }

    @Override
    public void loadCircleBorderImage(String url, int placeholder, ImageView imageView, float borderWidth, int borderColor) {

    }

    @Override
    public void loadCircleBorderImage(String url, int placeholder, ImageView imageView, float borderWidth, int borderColor, int heightPx, int widthPx) {

    }

    @Override
    public void loadGifImage(String url, int placeholder, ImageView imageView) {

    }

    @Override
    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {

    }


    @Override
    public void clearImageDiskCache(Context context) {

    }

    @Override
    public void clearImageMemoryCache(Context context) {

    }

    @Override
    public void trimMemory(Context context, int level) {

    }

    @Override
    public String getCacheSize(Context context) {
        return null;
    }

    @Override
    public void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener) {

    }

}
