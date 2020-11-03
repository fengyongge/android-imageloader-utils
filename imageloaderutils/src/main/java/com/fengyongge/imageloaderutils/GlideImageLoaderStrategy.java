package com.fengyongge.imageloaderutils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.fengyongge.imageloaderutils.listener.ImageLoaderStrategy;
import com.fengyongge.imageloaderutils.listener.ImageSaveListener;
import com.fengyongge.imageloaderutils.listener.ProgressLoadListener;
import com.fengyongge.imageloaderutils.transform.GlideCircleTransform;
import com.fengyongge.imageloaderutils.utils.GlideCacheUtils;

import java.io.File;

/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
class GlideImageLoaderStrategy implements ImageLoaderStrategy {

    @Override
    public void loadImageWithAppCxt(String url, ImageView imageView) {
        Glide.with(imageView.getContext().getApplicationContext())
                .load(url)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions()!=null?
                        ImageLoaderUtil.getInstance().getRequestOptions():new RequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageAssets(String asstes, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(asstes)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageResources(int resources, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resources)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageFile(File file, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(file)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }


    @Override
    public void loadImageUri(Uri uri, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(uri)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageByte(byte[] byteArray, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(byteArray)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadCircleImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
//                .transform(new GlideCircleTransform())
                .apply(ImageLoaderUtil.getInstance().getRequestOptions().circleCrop())
                .into(imageView);
    }

    @Override
    public void loadRoundImage(int roundingRadius,String url, ImageView imageView) {
        RoundedCorners roundedCorners = new RoundedCorners(roundingRadius);
        Glide.with(imageView.getContext())
                .load(url)
                .transform(new GlideCircleTransform())
                .apply(ImageLoaderUtil.getInstance().getRequestOptions().bitmapTransform(roundedCorners))
                .into(imageView);
    }

    @Override
    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor) {

    }

    @Override
    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPx, int widthPx) {

    }

    @Override
    public void loadGifImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .asGif()
                .load(url)
                .apply(ImageLoaderUtil.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {

    }

    @Override
    public void clearImageDiskCache(Context context) {
        //清空内存缓存，要求在主线程中执行
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearImageMemoryCache(Context context) {
        //清空磁盘缓存，要求在后台线程中执行
        Glide.get(context).clearDiskCache();
    }

    @Override
    public void trimMemory(Context context, int level) {

    }

    @Override
    public String getCacheSize(Context context) {
        try {
            return GlideCacheUtils.getFormatSize(GlideCacheUtils.getFolderSize(new File(context.getCacheDir() + "/"+ InternalCacheDiskCacheFactory.DEFAULT_DISK_CACHE_DIR)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public void saveImage(Context context, String url, String savePath, String saveFileName, ImageSaveListener listener) {

    }

}
