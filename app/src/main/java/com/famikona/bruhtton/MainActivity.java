package com.famikona.bruhtton;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button button_bruh;
    MediaPlayer mp;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.face);
        button_bruh = findViewById(R.id.btnBruh);
        mp = MediaPlayer.create(this, R.raw.bruh);
        img.setVisibility(View.INVISIBLE);
        button_bruh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                try {
                    if (mp.isPlaying()) {
                        mp.pause();
                        mp.seekTo(0);
                    }
                    img.setVisibility(View.VISIBLE);
                    mp.start();
                    runner();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                bruh(view);
            }
        });
    }

    public void runner() {
        Thread t = new Thread(new ImageRender());
        t.start();
    }

    class ImageRender implements Runnable {
        @Override
        public void run() {
            while (mp.isPlaying()) {
                synchronized (this) {
                    try {
                        wait(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    img.setVisibility(View.INVISIBLE);
                }
            });

        }
    }

    public void bruh (View view) {
        Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
    }
}
