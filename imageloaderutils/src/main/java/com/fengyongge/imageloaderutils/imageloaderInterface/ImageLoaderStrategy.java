package com.fengyongge.imageloaderutils.imageloaderInterface;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import java.io.File;

/**
 * describe
 * 对外开放API
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public interface ImageLoaderStrategy {

    void loadImageWithAppCxt(String url, ImageView imageView);

    void loadImage(Context context, String url, ImageView imageView);

    void preLoadImage(Context context,String url);

    void loadImage(String url, ImageView imageView);

    void loadImageAssets(String asstes, ImageView imageView);

    void loadImageResources(int resources, ImageView imageView);

    void loadImageFile(File file, ImageView imageView);

    void loadImageUri(Uri uri, ImageView imageView);

    void loadImageByte(byte[] byteArray, ImageView imageView);

    void loadRoundImage(int roundingRadius,String url, ImageView imageView);

    void loadCircleImage(String url, ImageView imageView);

    void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPx, int widthPx);

    void loadGifImage(String url, ImageView imageView);

    void loadGif2CommonImage(String url, ImageView imageView);

    void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener);

    void asyncDownloadImage(Context context, String url, String savePath, String saveFileName, ImageDownloadListener listener);

    void clearImageDiskCache(final Context context);

    void clearImageMemoryCache(Context context);

    String getCacheSize(Context context);

    void trimMemory(Context context, int level);


}