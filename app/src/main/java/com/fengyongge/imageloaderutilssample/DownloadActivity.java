package com.fengyongge.imageloaderutilssample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fengyongge.imageloaderutils.ImageLoaderSdk;
import com.fengyongge.imageloaderutils.imageloaderInterface.ImageDownloadListener;

/**
 * 图片下载，注意android 6.0需动态权限设置，android7.0需FileProvider设置
 */
public class DownloadActivity extends AppCompatActivity {

    //读写权限
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE};
    //请求状态码
    private static final int REQUEST_PERMISSION_CODE = 1;

    private String downloadUrl = "http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);

        findViewById(R.id.tvDownload1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                    if (ActivityCompat.checkSelfPermission(DownloadActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(DownloadActivity.this, PERMISSIONS_STORAGE, REQUEST_PERMISSION_CODE);
                    }else{
                        download();
                    }
                }else{
                    download();
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CODE) {
            boolean hasPermissionDismiss = false;
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == -1) {
                    hasPermissionDismiss = true;
                }
            }
            if (hasPermissionDismiss) {
                Toast.makeText(DownloadActivity.this, "请授权", Toast.LENGTH_SHORT).show();
            } else {
                download();
            }
        }


    }

    void download(){
        ImageLoaderSdk.getInstance().asyncDownloadImage(DownloadActivity.this, downloadUrl, System.currentTimeMillis() + ".jpg", "haha", new ImageDownloadListener() {
            @Override
            public void onDownloadSuccess() {

                Toast.makeText(DownloadActivity.this, "异步onDownloadSuccess", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onDownloadFail() {
                Toast.makeText(DownloadActivity.this, "异步onDownloadFail", Toast.LENGTH_SHORT).show();
            }
        });
    }
}