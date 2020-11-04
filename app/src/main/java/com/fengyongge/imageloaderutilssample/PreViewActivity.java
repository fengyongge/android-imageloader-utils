package com.fengyongge.imageloaderutilssample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.fengyongge.imageloaderutils.ImageLoaderSdk;

public class PreViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_view);

        ImageLoaderSdk.getInstance().setRequestOptions(R.drawable.default_image,R.drawable.default_image,R.drawable.default_image);

        ImageView imageView = findViewById(R.id.imageView1);
        ImageLoaderSdk.getInstance().loadImage("http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320",imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageLoaderSdk.getInstance().loadCircleImage("http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2",imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageLoaderSdk.getInstance().loadRoundImage(10,"http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320",imageView3);

    }
}