package com.fengyongge.imageloaderutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageDownloadListener;
import com.fengyongge.imageloaderutils.imageloaderInterface.ProgressLoadListener;
import com.fengyongge.imageloaderutils.imageloaderImple.GlideImageLoaderStrategy;
import com.fengyongge.imageloaderutils.constants.ImageLoaderStrategy;
import java.io.File;

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public class ImageLoaderSdk {
    private static ImageLoaderSdk mInstance;
    private com.fengyongge.imageloaderutils.imageloaderInterface.ImageLoaderStrategy mStrategy;
    private RequestOptions requestOptions;
    private String imageLoaderStrategy= ImageLoaderStrategy.ImageLoaderStrategy_TYPE_GLIDE;

    public ImageLoaderSdk() {
            if(imageLoaderStrategy.equals(ImageLoaderStrategy.ImageLoaderStrategy_TYPE_UNIVERSAL)){
                throw new UnsupportedOperationException("暂不支持 universal-image-loader");
            }else if(imageLoaderStrategy.equals(ImageLoaderStrategy.ImageLoaderStrategy_TYPE_FRESSO)){
                throw new UnsupportedOperationException("暂不支持 fresso");
            }else if(imageLoaderStrategy.equals(ImageLoaderStrategy.ImageLoaderStrategy_TYPE_PICASSO)){
                throw new UnsupportedOperationException("暂不支持 picasso");
            }else{
                mStrategy = new GlideImageLoaderStrategy();
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
     *
     */
    public void setImageLoaderStrategy(String imageLoaderUtilStrategy) {
        this.imageLoaderStrategy = imageLoaderUtilStrategy;
    }


    public RequestOptions getRequestOptions() {
        return requestOptions;
    }

    /**
     * 对外方法，设置图片加载的基本设置，展位图，错误图，请求url为空图片
     *
     */
    public void setRequestOptions(int placeholder,int error,int fallback) {
        RequestOptions options = new RequestOptions()
                //内存缓存和磁盘缓存
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                //优先级设置
                .priority(Priority.HIGH)
                //设置占位图
                .placeholder(placeholder)
                //设置错误图片
                .error(error)
                //url为null
                .fallback(fallback)
                .override(300, 300);
        this.requestOptions = options;
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
    public void loadImage(Context context,String url, ImageView imageView) {
        mStrategy.loadImage(context,url, imageView);
    }

    /**
     * 加载网络url图片
     */
    public void loadImage(String url,ImageView imageView) {
        mStrategy.loadImage(url, imageView);
    }
    /**
     * 加载asstes图片
     */
    public void loadImageAssets(String asstes,ImageView imageView) {
        mStrategy.loadImageAssets(asstes, imageView);
    }

    /**
     * 加载resources图片
     */
    public void loadImageResources(int resources,ImageView imageView) {
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
        mStrategy.loadGifImage(url,  imageView);
    }

    /**
     * 加载url图片，并设置圆角
     */
    public void loadRoundImage(int roundingRadius,String url, ImageView imageView) {
        mStrategy.loadRoundImage(roundingRadius,url,imageView);
    }


    /**
     * 加载url图片，设置圆形
     */
    public void loadCircleImage(String url, ImageView imageView) {
        mStrategy.loadCircleImage(url,imageView);
    }

    /**
     * 加载url图片，自定义一些属性
     */
    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPX, int widthPX) {
        mStrategy.loadCircleBorderImage(url,  imageView, borderWidth, borderColor, heightPX, widthPX);
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
    public void asyncDownloadImage(Context context, String url, String savePath, String saveFileName, ImageDownloadListener listener){
        mStrategy.asyncDownloadImage(context,url,savePath,saveFileName,listener);
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
