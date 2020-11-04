package com.fengyongge.imageloaderutils.imageloaderImple;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.fengyongge.imageloaderutils.ImageLoaderSdk;
import com.fengyongge.imageloaderutils.imageloaderImple.transform.GlideCircleTransform;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageDownloadListener;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageLoaderStrategy;
import com.fengyongge.imageloaderutils.imageloaderInterface.ProgressLoadListener;
import com.fengyongge.imageloaderutils.utils.FileUtils;
import com.fengyongge.imageloaderutils.utils.GlideCacheUtils;
import java.io.File;


/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public class GlideImageLoaderStrategy implements ImageLoaderStrategy {

    @Override
    public void loadImageWithAppCxt(String url, ImageView imageView) {
        Glide.with(imageView.getContext().getApplicationContext())
                .load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions()!=null?
                        ImageLoaderSdk.getInstance().getRequestOptions():new RequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageAssets(String asstes, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(asstes)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageResources(int resources, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(resources)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageFile(File file, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(file)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }


    @Override
    public void loadImageUri(Uri uri, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(uri)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageByte(byte[] byteArray, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(byteArray)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadCircleImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
//                .transform(new GlideCircleTransform())
                .apply(ImageLoaderSdk.getInstance().getRequestOptions().circleCrop())
                .into(imageView);
    }

    @Override
    public void loadRoundImage(int roundingRadius,String url, ImageView imageView) {
        RoundedCorners roundedCorners = new RoundedCorners(roundingRadius);
        Glide.with(imageView.getContext())
                .load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .apply(RequestOptions.bitmapTransform(roundedCorners))
                .into(imageView);
    }

    @Override
    public void loadCircleBorderImage(String url, ImageView imageView, float borderWidth, int borderColor, int heightPx, int widthPx) {
        Glide.with(imageView.getContext()).load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .transform(new GlideCircleTransform(imageView.getContext(),borderWidth,borderColor,heightPx,widthPx))
                .into(imageView);
    }

    @Override
    public void loadGifImage(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .asGif()
                .load(url)
                .apply(ImageLoaderSdk.getInstance().getRequestOptions())
                .into(imageView);
    }

    @Override
    public void loadImageWithProgress(String url, ImageView imageView, ProgressLoadListener listener) {

    }

    @Override
    public void asyncDownloadImage(final Context context, String url, final String savePath, final String saveFileName, final ImageDownloadListener listener) {
//        Glide.with(context)
//                .downloadOnly()
//                .load(url)
//                .addListener(new RequestListener<File>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<File> target, boolean isFirstResource) {
//                        listener.onDownloadFail();
//                        return false;
//                    }
//                    @Override
//                    public boolean onResourceReady(File resource, Object model, Target<File> target, DataSource dataSource, boolean isFirstResource) {
//                        File destFile = FileUtils.savaFileUtils(context, true, savePath,saveFileName);
//                        FileUtils.copy(resource, destFile);
//                        NotifyUtils.refreshSystemPic(context, destFile);
//                        listener.onDownloadSuccess();
//                        return false;
//                    }
//                }).preload();

        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(new CustomTarget<Bitmap>(){
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        File destFile = FileUtils.savaFileUtils(context, true, savePath,saveFileName);
                        FileUtils.saveBitmap2File(context,resource,destFile);
                        listener.onDownloadSuccess();
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        listener.onDownloadFail();
                    }
                });
    }

        @Override
    public void clearImageDiskCache(Context context) {
        //清空内存缓存，要求在主线程中执行
        Glide.get(context).clearMemory();
    }

    @Override
    public void clearImageMemoryCache(Context context) {
        //清空磁盘缓存，要求在子线程中执行
        Glide.get(context).clearDiskCache();
    }

    @Override
    public void trimMemory(Context context, int level) {
        //裁剪 Glide 缓存的图片内存空间
        Glide.get(context).trimMemory(level);
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


}
