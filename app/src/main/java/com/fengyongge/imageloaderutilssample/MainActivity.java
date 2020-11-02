package com.fengyongge.imageloaderutilssample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fengyongge.imageloaderutilssample.friendscircle.FirendsCircleActivity;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvTest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FirendsCircleActivity.class));
            }
        });
    }


}
