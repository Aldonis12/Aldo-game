package com.game.aldo_game;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    ImageView logoFb;
    TextView fb1;

    ImageView google;
    TextView google1;

    ImageView insta;
    TextView insta1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView(R.layout.nav_header);

        ImageView logoFb = findViewById(R.id.fb);
        TextView fb1 = findViewById(R.id.fb1);

        ImageView google = findViewById(R.id.google);
        TextView google1 = findViewById(R.id.google1);

        ImageView insta = findViewById(R.id.insta);
        TextView insta1 = findViewById(R.id.insta1);

        TextView titre = findViewById(R.id.titre);
        TextView create = findViewById(R.id.create);

        String text = "Titre : AldoGame";
        String text2 = "Createur : HERITRA Aldonis Mick Lewis";

        SpannableString ss = new SpannableString(text);
        SpannableString ss1 = new SpannableString(text2);
        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
        ForegroundColorSpan fcsBlack = new ForegroundColorSpan(Color.BLACK);
        ForegroundColorSpan fcsMag = new ForegroundColorSpan(Color.CYAN);
        ForegroundColorSpan fcsOrange = new ForegroundColorSpan(Color.RED);

        ss.setSpan(fcsBlack, 0, 7, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(fcsRed, 8, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        ss1.setSpan(fcsBlack, 0, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss1.setSpan(fcsRed, 11, 37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        titre.setText(ss);
        create.setText(ss1);

        logoFb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/micklewis.aldonis/");
            }
        });

        fb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.facebook.com/micklewis.aldonis/");
            }
        });


        google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://mailto:micklewis.aldonis@gmail.com/");
            }
        });

        google1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://mailto:micklewis.aldonis@gmail.com/");
            }
        });

        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/micklewis_aldonis/");
            }
        });

        insta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoUrl("https://www.instagram.com/micklewis_aldonis/");
            }
        });
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}
