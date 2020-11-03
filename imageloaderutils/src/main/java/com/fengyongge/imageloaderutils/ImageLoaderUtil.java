package com.fengyongge.imageloaderutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fengyongge.imageloaderutils.listener.ImageLoaderStrategy;
import com.fengyongge.imageloaderutils.listener.ImageSaveListener;
import com.fengyongge.imageloaderutils.listener.ProgressLoadListener;

import java.io.File;

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public class ImageLoaderUtil {

    private static ImageLoaderUtil mInstance;
    private ImageLoaderStrategy mStrategy;
    private RequestOptions requestOptions;

    public ImageLoaderUtil() {
        mStrategy = new GlideImageLoaderStrategy();
    }

    public static ImageLoaderUtil getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderUtil.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderUtil();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    public RequestOptions getRequestOptions() {
        return requestOptions;
    }
    public void setRequestOptions(int placeholder,int error,int fallback) {
        RequestOptions options = new RequestOptions()
                //关闭内存缓存和磁盘缓存
                .skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE)
                //优先级设置
                .priority(Priority.HIGH)
                .placeholder(placeholder)//设置占位图
                .error(error)//设置错误图片
                .fallback(fallback)//url为null
                .override(300, 300);
        this.requestOptions = options;
    }

    public void loadImageWithAppCxt(String url, ImageView imageView) {
        mStrategy.loadImageWithAppCxt(url, imageView);
    }

    public void loadImage(Context context,String url, ImageView imageView) {
        mStrategy.loadImage(context,url, imageView);
    }

    public void loadImage(String url,ImageView imageView) {
        mStrategy.loadImage(url, imageView);
    }

    public void loadImageAssets(String asstes,ImageView imageView) {
        mStrategy.loadImageAssets(asstes, imageView);
    }

    public void loadImageResources(int resources,ImageView imageView) {
        mStrategy.loadImageResources(resources, imageView);
    }

    public void loadImageFile(File file, ImageView imageView) {
        mStrategy.loadImageFile(file, imageView);
    }

    public void loadImageUri(Uri uri, ImageView imageView) {
        mStrategy.loadImageUri(uri, imageView);
    }

    public void loadImageByte(byte[] byteArray, ImageView imageView) {
        mStrategy.loadImageByte(byteArray, imageView);
    }

    public void loadGifImage(String url, ImageView imageView) {
        mStrategy.loadGifImage(url,  imageView);
    }

    public void loadRoundImage(int roundingRadius,String url, ImageView imageView) {
        mStrategy.loadRoundImage(roundingRadius,url,imageView);
    }

    public void loadCircleImage(String url, ImageView imageView) {
        mStrategy.loadCircleImage(url,  imageView);
    }

    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor) {
        mStrategy.loadCircleBorderImage(url,  imageView, borderWidth, borderColor);
    }

    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPX, int widthPX) {
        mStrategy.loadCircleBorderImage(url,  imageView, borderWidth, borderColor, heightPX, widthPX);
    }

    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {
        mStrategy.loadImageWithProgress(url, imageView, listener);
    }

    /**
     * 策略模式的注入操作
     *
     * @param strategy
     */
    public void setLoadImgStrategy(ImageLoaderStrategy strategy) {
        mStrategy = strategy;
    }

    /**
     * 清除图片磁盘缓存
     */
    public void clearImageDiskCache(final Context context) {
        mStrategy.clearImageDiskCache(context);
    }

    /**
     * 清除图片内存缓存
     */
    public void clearImageMemoryCache(Context context) {
        mStrategy.clearImageMemoryCache(context);
    }

    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context
     * @param level
     */
    public void trimMemory(Context context, int level) {
        mStrategy.trimMemory(context, level);
    }

    /**
     * 清除图片所有缓存
     */
    public void clearImageAllCache(Context context) {
        clearImageDiskCache(context.getApplicationContext());
        clearImageMemoryCache(context.getApplicationContext());
    }

    /**
     * 获取缓存大小
     *
     * @return CacheSize
     */
    public String getCacheSize(Context context) {
        return mStrategy.getCacheSize(context);
    }

    public void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener) {
        mStrategy.saveImage(context, url, savePath, saveFileName, listener);
    }

}
