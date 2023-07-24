package com.game.aldo_game;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static int duree=5000;
    ImageView imageView;
    TextView textView;
    Animation topanim,bottomanim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.activity_main);

        imageView=findViewById (R.id.logo);
        textView=findViewById (R.id.slogan);

        topanim=AnimationUtils.loadAnimation(this,R.anim.animation_top);
        bottomanim= AnimationUtils.loadAnimation(this,R.anim.animation_bottom);
        imageView.setAnimation(topanim);
        textView.setAnimation(bottomanim);

        new Handler ().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(MainActivity.this,PasssageActivity.class);
                startActivity (intent);
                finish();
            }
        },duree);
    }
}