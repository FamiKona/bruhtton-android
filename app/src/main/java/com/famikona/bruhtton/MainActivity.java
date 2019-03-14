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
        img = findViewById(R.id.imageView);
        brtn = findViewById(R.id.btnBruh);
        mp = MediaPlayer.create(this, R.raw.bruh);
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

//    Thread imageRender = new Thread() {
//        @Override
//        public void run() {
//            if (mp.isPlaying() && img.getVisibility() == View.INVISIBLE) {
//                img.setVisibility(View.VISIBLE);
//            } else if (!mp.isPlaying() && img.getVisibility() == View.VISIBLE) {
//                img.setVisibility(View.INVISIBLE);
//            }
//        }
//    };
//
//    imageRender.start();

    public void bruh (View view) {
        Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
    }
}
