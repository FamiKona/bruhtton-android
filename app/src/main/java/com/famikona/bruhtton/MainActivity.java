package com.famikona.bruhtton;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button brtn;
    MediaPlayer mp;
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.face);
        brtn = findViewById(R.id.btnBruh);
        mp = MediaPlayer.create(this, R.raw.bruh);
        Thread t1 = new Thread(new ImageRender());
        t1.start();
        brtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                img.setVisibility(View.VISIBLE);
                try {
                    if (mp.isPlaying()) {
                        mp.pause();
                        mp.seekTo(0);
                    }
                    mp.start();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                bruh(view);
                img.setVisibility(View.INVISIBLE);
            }
        });
    }

    class ImageRender implements Runnable {
        @Override
        public void run() {
            while (true) {
                //System.out.println("yeet"); // checks if loop is running
                if (mp.isPlaying() && img.getVisibility() == View.INVISIBLE) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img.setVisibility(View.VISIBLE);
                        }
                    });
                } else if (!mp.isPlaying() && img.getVisibility() == View.VISIBLE) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            img.setVisibility(View.INVISIBLE);
                        }
                    });
                }
            }
        }
    }

    public void bruh (View view) {
        Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
    }
}
