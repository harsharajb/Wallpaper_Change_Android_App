package com.example.changewallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Button wallbtn;
    Timer myTimer;
    WallpaperManager wpm;
    Drawable drawable;
    int prev = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wallbtn=findViewById(R.id.button);
        myTimer=new Timer();
        wpm = WallpaperManager.getInstance(this);
        wallbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
            }
        });
    }

    private void setWallpaper() {
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1){
                    drawable=getResources().getDrawable(R.drawable.bg1);
                    prev=2;
                }
               else if(prev==2){
                    drawable=getResources().getDrawable(R.drawable.bg2);
                    prev=3;
                }
                else if(prev==3){
                    drawable=getResources().getDrawable(R.drawable.bg3);
                    prev=4;
                }
                else if(prev==4){
                    drawable=getResources().getDrawable(R.drawable.bg4);
                    prev=1;
                }
                Bitmap wallpaper= ((BitmapDrawable)drawable).getBitmap();
                try{
                    wpm.setBitmap(wallpaper);
                }
                catch (IOException e){
                    e.printStackTrace();
                }
            }
        }, 0, 3000);

    }
}