package com.example.healthguidesystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class splash extends AppCompatActivity {
private TextView tv;
private ImageView im;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        im = (ImageView) findViewById(R.id.image);
        tv = (TextView) findViewById(R.id.text);
        Animation anime = AnimationUtils.loadAnimation(this,R.anim.mytransition);

        tv.startAnimation(anime);
        im.startAnimation(anime);

        Thread timer = new Thread(){
            public  void run(){
                try{
                    sleep(2500);

                }catch ( InterruptedException e){
                    e.printStackTrace();
                }
                finally {

                    startActivity(new Intent(splash.this, LoginActivity.class));
                    finish();

                }
            }
        };
        timer.start();

    }
}
