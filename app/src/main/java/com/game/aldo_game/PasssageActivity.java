package com.game.aldo_game;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class PasssageActivity extends AppCompatActivity {
    private Button button;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Vibrator vib;
    private ImageView imga;
    private Button icon;
    int i =0;

    MediaPlayer mysong;
    MediaPlayer mysong1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passsage);
        mysong = MediaPlayer.create(PasssageActivity.this,R.raw.music);
        mysong1 = MediaPlayer.create(PasssageActivity.this,R.raw.tokmus);
            for (i = 0; i < 10; i++) {
                mysong1.start();
                break;
            }


        button = (Button) findViewById(R.id.Buttondice);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasssageActivity.this,ActivityDice.class);
                startActivity(i);
            }
        });

        button1 = (Button) findViewById(R.id.Buttontic);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasssageActivity.this,ActivityTic.class);
                startActivity(i);
            }
        });


        button2 = (Button) findViewById(R.id.Buttonquiz);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasssageActivity.this,QuizActivity.class);
                startActivity(i);
            }
        });

        button3 = (Button) findViewById(R.id.ButtonBottle);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(PasssageActivity.this,AboutActivity.class);
                startActivity(i);
            }
        });

        final Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        final long[] pattern = {0,200,10,500};

        final Button button4 = findViewById(R.id.Buttonserp);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                    vib.vibrate(VibrationEffect.createOneShot(500,VibrationEffect.DEFAULT_AMPLITUDE));
                    Toast.makeText(PasssageActivity.this,"Cette option n'est pas encore disponible pour le moment, veuillez réessayer plus tard!", Toast.LENGTH_SHORT).show();
                    //button4.setText("NON DISPONIBLE");
                }
            }
        });
    }

    public void pauseITi(View v) {
        super.onPause();
        mysong.release();
    }

    public void pauseIT(View v) {
        icon = findViewById(R.id.musOff);
        super.onPause();
        mysong1.release();
        icon.setText("ok");
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(R.drawable.logo)
                .setTitle("ALDO-GAME")
                .setMessage("Etes vous sur de vouloir quitter?")
                .setCancelable(false)

                .setPositiveButton("OUI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("NON",null)
                .show();
    }

    public boolean onCreateOptionMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.exit){
            AlertDialog.Builder builder = new AlertDialog.Builder(PasssageActivity.this);
            builder.setMessage("Dia sahinao tokoa va???");
            builder.setCancelable(true);

            builder.setNegativeButton("IENY AVY HATRANY", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            builder.setPositiveButton("AO ARY EHH", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return true;
    }
}