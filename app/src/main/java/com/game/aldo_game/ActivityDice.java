package com.game.aldo_game;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class ActivityDice extends AppCompatActivity {

    private ImageView info;
    TextView textView;
    ImageView imageView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dice_main);

        textView =  findViewById(R.id.score);
        button = findViewById(R.id.buttonRoll);
        imageView = findViewById(R.id.diceImage);


        info = (ImageView) findViewById(R.id.infoDé);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog() {
                ExempleDialog_dé exempleDialog = new ExempleDialog_dé();
                exempleDialog.show(getSupportFragmentManager(),"exemple dialog");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int score = random.nextInt(6) + 1;
                textView.setText(String.valueOf(score));

                switch (score){
                    case 1:
                        imageView.setImageResource(R.drawable.dice1);
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.dice2);
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.dice3);
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.dice4);
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.dice5);
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.dice6);
                        break;
                }
            }
        });
    }
}
