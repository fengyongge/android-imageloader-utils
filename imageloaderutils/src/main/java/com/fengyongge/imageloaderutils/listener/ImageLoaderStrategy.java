package com.fengyongge.imageloaderutils.listener;

import android.content.Context;
import android.widget.ImageView;

/**
 * describe
 * 对外开放API
 * @author fengyongge
 * @data 2020/11/2
 */
public interface ImageLoaderStrategy {

    void loadImage(String url, ImageView imageView);

    void loadImageWithAppCxt(String url, ImageView imageView);

    void loadImage(String url, int placeholder, ImageView imageView);

    void loadImage(Context context, String url, int placeholder, ImageView imageView);

    void loadCircleImage(String url, int placeholder, ImageView imageView);

    void loadCircleBorderImage(String url, int placeholder, ImageView imageView,float borderWidth, int borderColor);

    void loadCircleBorderImage(String url, int placeholder, ImageView imageView,float borderWidth, int borderColor, int heightPx, int widthPx);

    void loadGifImage(String url, int placeholder, ImageView imageView);

    void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener);

    void clearImageDiskCache(final Context context);

    void clearImageMemoryCache(Context context);

    void trimMemory(Context context, int level);

    String getCacheSize(Context context);

    void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener);

}