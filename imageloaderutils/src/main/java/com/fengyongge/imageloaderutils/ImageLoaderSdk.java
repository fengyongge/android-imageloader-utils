package com.fengyongge.imageloaderutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fengyongge.imageloaderutils.imageloaderImple.FressoStrategy;
import com.fengyongge.imageloaderutils.imageloaderImple.PicassoStrategy;
import com.fengyongge.imageloaderutils.imageloaderImple.UniversalImageloderStrategy;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageDownloadListener;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageLoaderStrategy;
import com.fengyongge.imageloaderutils.imageloaderInterface.ProgressLoadListener;
import com.fengyongge.imageloaderutils.imageloaderImple.GlideStrategy;
import com.fengyongge.imageloaderutils.constants.ImageLoaderStrategyEnum;

import java.io.File;

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public class ImageLoaderSdk {
    private static volatile ImageLoaderSdk mInstance;
    private ImageLoaderStrategy mStrategy;
    private ImageLoaderStrategyEnum imageLoaderStrategyEnum = ImageLoaderStrategyEnum.GLIDE;
    /**
     * 设置是否开启内存缓存
     */
    private boolean isMemoryCache = false;
    /**
     * 设置是否开启磁盘缓存
     */
    private boolean isDiskCache = true;
    /**
     * 设置图片是否展示占位图
     */
    private int placeholder;
    /**
     * 设置图片是否展示错误图
     */
    private int error;
    /**
     * 设置图片是否展示网络错误图片
     */
    private int fallback;
    /**
     * 设置是否更改图片宽度
     */
    private int width;
    /**
     * 设置是否开启图片高度
     */
    private int height;

    public boolean isMemoryCache() {
        return isMemoryCache;
    }

    public void setMemoryCache(boolean memoryCache) {
        isMemoryCache = memoryCache;
    }

    public boolean isDiskCache() {
        return isDiskCache;
    }

    public void setDiskCache(boolean diskCache) {
        isDiskCache = diskCache;
    }

    public int getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(int placeholder) {
        this.placeholder = placeholder;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public int getFallback() {
        return fallback;
    }

    public void setFallback(int fallback) {
        this.fallback = fallback;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ImageLoaderSdk() {
        switch (imageLoaderStrategyEnum) {
            case UNIVERSAL_IMAGE_LOADER:
                mStrategy = new UniversalImageloderStrategy();
                break;
            case FRESSO:
                mStrategy = new FressoStrategy();
                break;
            case PICASSO:
                mStrategy = new PicassoStrategy();
                break;
            default:
                mStrategy = new GlideStrategy();
                break;
        }
    }

    public static ImageLoaderSdk getInstance() {
        if (mInstance == null) {
            synchronized (ImageLoaderSdk.class) {
                if (mInstance == null) {
                    mInstance = new ImageLoaderSdk();
                    return mInstance;
                }
            }
        }
        return mInstance;
    }

    /**
     * 对外方法，选择底层图片框架的选择，默认使用glide
     */
    public void setImageLoaderStrategy(ImageLoaderStrategyEnum imageLoaderStrategyEnum) {
        this.imageLoaderStrategyEnum = imageLoaderStrategyEnum;
    }



   public  RequestOptions getRequestOptions() {
       DiskCacheStrategy diskCacheStrategy;
       if(isDiskCache()){
            diskCacheStrategy = DiskCacheStrategy.ALL;
       }else{
           diskCacheStrategy = DiskCacheStrategy.NONE;
       }
       RequestOptions options =new RequestOptions();
       //优先级设置
       options.priority(Priority.HIGH)
               //设置占位图
               .placeholder(getPlaceholder() != 0 ? getPlaceholder() : R.drawable.default_image)
               //设置错误图片
               .error(getError() != 0 ? getError() : R.drawable.default_image)
               //url为null
               .fallback(getFallback() != 0 ? getFallback() : R.drawable.default_image)
               //指定图片大小
               .override(width, height)
               .skipMemoryCache(!isMemoryCache())
               .diskCacheStrategy(diskCacheStrategy);
       return options;
   }


    /**
     * 加载图片
     */
    public void loadImageWithAppCxt(String url, ImageView imageView) {
        mStrategy.loadImageWithAppCxt(url, imageView);
    }

    /**
     * 加载图片
     */
    public void loadImage(Context context, String url, ImageView imageView) {
        mStrategy.loadImage(context, url, imageView);
    }

    /**
     * 预加载图片
     */
    public void preLoadImage(Context context, String url) {
        mStrategy.preLoadImage(context, url);
    }

    /**
     * 加载网络url图片、包含Gif图片
     */
    public void loadImage(String url, ImageView imageView) {
        mStrategy.loadImage(url, imageView);
    }

    /**
     * 加载asstes图片
     */
    public void loadImageAssets(String asstes, ImageView imageView) {
        mStrategy.loadImageAssets(asstes, imageView);
    }

    /**
     * 加载resources图片
     */
    public void loadImageResources(int resources, ImageView imageView) {
        mStrategy.loadImageResources(resources, imageView);
    }

    /**
     * 加载file图片
     */
    public void loadImageFile(File file, ImageView imageView) {
        mStrategy.loadImageFile(file, imageView);
    }

    /**
     * 加载uri图片
     */
    public void loadImageUri(Uri uri, ImageView imageView) {
        mStrategy.loadImageUri(uri, imageView);
    }

    /**
     * 加载byteArray图片
     */
    public void loadImageByte(byte[] byteArray, ImageView imageView) {
        mStrategy.loadImageByte(byteArray, imageView);
    }

    /**
     * 加载gif图片
     */
    public void loadGifImage(String url, ImageView imageView) {
        mStrategy.loadGifImage(url, imageView);
    }

    /**
     * 加载gif图片，强制转成载静态图片，取gif的第一帧
     */
    public void loadGif2CommonImage(String url, ImageView imageView) {
        mStrategy.loadGif2CommonImage(url, imageView);
    }


    /**
     * 加载url图片，并设置圆角
     */
    public void loadRoundImage(int roundingRadius, String url, ImageView imageView) {
        mStrategy.loadRoundImage(roundingRadius, url, imageView);
    }


    /**
     * 加载url图片，设置圆形
     */
    public void loadCircleImage(String url, ImageView imageView) {
        mStrategy.loadCircleImage(url, imageView);
    }

    /**
     * 加载url图片，自定义一些属性
     */
    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPX, int widthPX) {
        mStrategy.loadCircleBorderImage(url, imageView, borderWidth, borderColor, heightPX, widthPX);
    }

    /**
     * 加载url图片，获取加载进度
     */
    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {
        mStrategy.loadImageWithProgress(url, imageView, listener);
    }


    /**
     * 异步下载图片
     */
    public void asyncDownloadImage(Context context, String url, String savePath, String saveFileName, ImageDownloadListener listener) {
        mStrategy.asyncDownloadImage(context, url, savePath, saveFileName, listener);
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


    /**
     * 根据不同的内存状态，来响应不同的内存释放策略
     *
     * @param context
     * @param level
     */
    public void trimMemory(Context context, int level) {
        mStrategy.trimMemory(context, level);
    }

}
