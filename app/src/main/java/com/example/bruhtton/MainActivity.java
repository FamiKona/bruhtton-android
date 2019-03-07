package com.example.bruhtton;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button brtn;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        brtn = findViewById(R.id.btnBruh);
        mp = MediaPlayer.create(this, R.raw.bruh);
        brtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

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
            }
        });
    }

    public void bruh (View view) {
        Toast.makeText(this, "bruh", Toast.LENGTH_SHORT).show();
    }
}
