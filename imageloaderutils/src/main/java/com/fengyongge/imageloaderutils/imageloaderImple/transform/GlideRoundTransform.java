package com.fengyongge.imageloaderutils.imageloaderImple.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import com.bumptech.glide.util.Util;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

import androidx.annotation.NonNull;
/**
 * describe
 *
 * @author fengyongge
 * @data 2020/11/2
 */
public class GlideRoundTransform extends BitmapTransformation {

    private static final String ID = GlideRoundTransform.class.getName();
    private static final byte[] ID_BYTES = ID.getBytes(CHARSET);

    final GradientDrawable drawable;

    GlideRoundTransform(GradientDrawable d) {
        this.drawable = d;
    }

    @Override
    protected Bitmap transform(
            @NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {

        Bitmap bitmap = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            bitmap = TransformationUtils.roundedCorners(pool, toTransform, (int) drawable.getCornerRadius());
        }

        Canvas canvas = new Canvas(bitmap);

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);

        canvas.setBitmap(null);
        return bitmap;
    }

    @Override
    public int hashCode() {
        return Util.hashCode(ID.hashCode(), drawable.hashCode());
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID_BYTES);

        {
            byte[] radiusData = ByteBuffer.allocate(4).putInt(drawable.hashCode()).array();
            messageDigest.update(radiusData);
        }

    }
}
