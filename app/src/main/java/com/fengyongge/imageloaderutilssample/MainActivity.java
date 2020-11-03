package com.fengyongge.imageloaderutilssample;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.fengyongge.imageloaderutils.ImageLoaderUtil;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageLoaderUtil.getInstance().setRequestOptions(R.drawable.back_arrow,R.drawable.back_arrow,R.drawable.back_arrow);

        ImageView imageView = findViewById(R.id.imageView1);
        ImageLoaderUtil.getInstance().loadImage("http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320",imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        ImageLoaderUtil.getInstance().loadCircleImage("http://gank.io/images/f4f6d68bf30147e1bdd4ddbc6ad7c2a2",imageView2);
        ImageView imageView3 = findViewById(R.id.imageView3);
        ImageLoaderUtil.getInstance().loadRoundImage(10,"http://gank.io/images/dc75cbde1d98448183e2f9514b4d1320",imageView3);


    }


}
