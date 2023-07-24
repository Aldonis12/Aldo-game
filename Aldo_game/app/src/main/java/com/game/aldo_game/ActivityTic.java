package com.game.aldo_game;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityTic extends AppCompatActivity implements View.OnClickListener {

    private ImageView info;
    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button[] buttons = new Button[9];
    private Button resetGame;

    private int playerOneScoreCount, playerTwoScoreCount, rountCount;
    boolean activePlayer;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositions = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //ROWS
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //COLONNE
            {0, 4, 8}, {2, 4, 6} //CROSS
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tictac_main);

        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);
        playerStatus = findViewById(R.id.playerStatus);

        resetGame = findViewById(R.id.resetGame);

        for (int i = 0; i < buttons.length; i++) {
            String buttonID = "btn_" + i;
            int ressourceID = getResources().getIdentifier(buttonID, "id", getPackageName());
            buttons[i] = findViewById(ressourceID);
            buttons[i].setOnClickListener(this);
        }

        rountCount = 0;
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        activePlayer = true;


        info = (ImageView) findViewById(R.id.infoTic);
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }

            private void openDialog() {
                ExempleDialog exempleDialog = new ExempleDialog();
                exempleDialog.show(getSupportFragmentManager(),"exemple dialog");
            }
        });

        /*public void openDialog() {
            ExempleDialog exempleDialog = new ExempleDialog();
            exempleDialog.show(getSupportFragmentManager(),"exemple dialog");
        }*/

    }

    @Override
    public void onClick(View view) {
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        String buttonID = view.getResources().getResourceEntryName(view.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length() - 1, buttonID.length()));

        if (activePlayer) {
            ((Button) view).setText("X");
            ((Button) view).setTextColor(Color.parseColor("#9999ff"));
            gameState[gameStatePointer] = 0;
        } else {
            ((Button) view).setText("O");
            ((Button) view).setTextColor(Color.parseColor("#ff9999"));
            gameState[gameStatePointer] = 1;
        }
        rountCount++;

        if(checkWinner()) {
            if (activePlayer){
                playerOneScoreCount++;
                updatePlayerScore();
                //Toast.makeText(this,"1 no nahazo", Toast.LENGTH_SHORT).show();
                playAgain();
            }else{
                playerTwoScoreCount++;
                updatePlayerScore();
                //Toast.makeText(this,"2 ko tsy misangy", Toast.LENGTH_SHORT).show();
                playAgain();
            }
        }if(rountCount == 9) {
            Toast.makeText(this,"SAMY MAFY EH!", Toast.LENGTH_SHORT).show();
            //playerStatus.setText("Tena miady ny lalao");
            playAgain();
        }else{
            activePlayer = !activePlayer;
        }

        if (playerOneScoreCount > playerTwoScoreCount) {
            playerStatus.setText("Mitarika ny mpilalao 1");
        }else if(playerTwoScoreCount > playerOneScoreCount) {
            playerStatus.setText("Mitarika ny mpilalao 2");
        }else if(playerTwoScoreCount == playerOneScoreCount) {
            playerStatus.setText("Miady ny lalao");
        }else {
            playerStatus.setText("");
        }

        if (playerOneScoreCount == 3){
            TicWinOneDialog exempleDialog = new TicWinOneDialog();
            exempleDialog.show(getSupportFragmentManager(),"exemple dialog");
            playAgain();
            playerOneScoreCount = 0;
            playerTwoScoreCount = 0;
            playerStatus.setText("");
            updatePlayerScore();
        }

        if (playerTwoScoreCount == 3){
            TicWinTwoDialog exempleDialog = new TicWinTwoDialog();
            exempleDialog.show(getSupportFragmentManager(),"exemple dialog");
            playAgain();
            playerOneScoreCount = 0;
            playerTwoScoreCount = 0;
            playerStatus.setText("");
            updatePlayerScore();
        }
        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
                playerOneScoreCount = 0;
                playerTwoScoreCount = 0;
                playerStatus.setText("");
                updatePlayerScore();
            }
        });
    }

    public boolean checkWinner() {
        boolean winnerResult = false;

        for (int[] winnigPosition : winningPositions) {
            if (gameState[winnigPosition[0]] == gameState[winnigPosition[1]] &&
                    gameState[winnigPosition[1]] == gameState[winnigPosition[2]] &&
                    gameState[winnigPosition[0]] != 2) {
                winnerResult = true;
            }
        }
        return winnerResult;
    }

    public void updatePlayerScore (){
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void playAgain(){
        rountCount = 0;
        activePlayer = true;

        for (int i= 0; i < buttons.length; i++){
            gameState[i] = 2;
            buttons[i].setText("");
        }
    }
}
