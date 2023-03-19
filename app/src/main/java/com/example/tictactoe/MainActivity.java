package com.example.tictactoe;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    int playerActive=0;
    int[] gameState ={2,2,2,2,2,2,2,2,2};

    int beforeWining=0;

    public static int count=0;
    boolean gameActive=true;
   int[][] winningPosition = {{0,1,2,},{3,4,5},{6,7,8,},
                                {0,3,6,},{1,4,7},{2,5,8},
                                {0,4,8},{2,4,6}};

    @SuppressLint("SetTextI18n")
    public void onImageTap(View view) {
        ImageView imageView =(ImageView)view;

        int imageTapped = Integer.parseInt(imageView.getTag().toString());


        if(gameState[imageTapped]==2&&beforeWining!=1)
        {
            count++;
            gameState[imageTapped] = playerActive;
            imageView.setTranslationY(-1000f);
            if (count == 9)
            {
                gameActive = false;
            }
            if (playerActive == 0)
            {
                playerActive = 1;
                imageView.setImageResource(R.drawable.zero);
                TextView status = findViewById(R.id.textView2);
                status.setText("X's Turn");
            }
            else
            {
                playerActive = 0;
                imageView.setImageResource(R.drawable.x);
                TextView status = findViewById(R.id.textView2);
                status.setText("0's Turn");

            }

            imageView.animate().translationYBy(1000f).setDuration(300);
            int draw = 1;
            for (int[] winningPosition : winningPosition)
            {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]]
                        && gameState[winningPosition[0]] != 2) {
                    draw = 0;//not a draw
                    String winner;
                    gameActive=false;
                    if (gameState[winningPosition[0]] == 0) {
                        winner = "0 has won ";
                        beforeWining=1;
                    } else {
                        winner = "x has won";
                        beforeWining=1;
                    }
                   TextView status = findViewById(R.id.textView2);
                    status.setText(winner);
                    Button playAgainButton = findViewById(R.id.button);
                    playAgainButton.setVisibility(View.VISIBLE);
                    gameActive=false;
                }
            }
            //draw condition
               if(count==9&&draw==1){
                TextView status = findViewById(R.id.textView2);
                status.setText("Match draw");
                gameActive=false;
                Button playAgainButton = findViewById(R.id.button);
                playAgainButton.setVisibility(View.VISIBLE);

            }

        }
    }
    @SuppressLint("SetTextI18n")
    public void playAgain(View view)
    {

        Button playAgainButton = findViewById(R.id.button);
        playAgainButton.setVisibility(View.INVISIBLE);

        TextView status =findViewById(R.id.textView2);
        status.setText("0's Turn");
        gameActive=true;
        playerActive=0;
        count =0;
        beforeWining=0;

        int i;
        for (i = 0; i<gameState.length; i++)
        {
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageview0)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview1)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview2)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview3)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview4)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview5)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview6)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview7)).setImageDrawable(null);
        ((ImageView)findViewById(R.id.imageview8)).setImageDrawable(null);



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button playAgainButton =findViewById(R.id.button);
                playAgainButton.setVisibility(View.INVISIBLE);
        setDefaultNightMode(MODE_NIGHT_NO);
    }
}