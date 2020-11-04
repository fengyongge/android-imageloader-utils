package com.fengyongge.imageloaderutilssample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fengyongge.imageloaderutils.ImageLoaderSdk;

public class CacheActivity extends AppCompatActivity {

    TextView tvDisk,tvMemory,tvTest3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cache);

        tvDisk = findViewById(R.id.tvDisk);
        tvDisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImageLoaderSdk.getInstance().clearImageDiskCache(CacheActivity.this);
                tvTest3.setText(ImageLoaderSdk.getInstance().getCacheSize(CacheActivity.this));
                Toast.makeText(CacheActivity.this,"磁盘缓存清理",Toast.LENGTH_SHORT).show();
            }
        });
        tvMemory = findViewById(R.id.tvMemory);
        tvMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ImageLoaderSdk.getInstance().clearImageMemoryCache(CacheActivity.this);
                    }
                }).start();
                Toast.makeText(CacheActivity.this,"内存缓存清理",Toast.LENGTH_SHORT).show();
                tvTest3.setText(ImageLoaderSdk.getInstance().getCacheSize(CacheActivity.this));
            }
        });

        tvTest3 = findViewById(R.id.tvTest3);
        tvTest3.setText(ImageLoaderSdk.getInstance().getCacheSize(CacheActivity.this));

    }
}