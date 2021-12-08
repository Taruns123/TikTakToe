package com.example.finaloopmminiproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class ComputerActivity extends AppCompatActivity {

        boolean gameActive = true;

        int activePlayer = 0;
        int[] gameState = {2, 2 , 2, 2, 2, 2, 2, 2, 2};

        int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
                {0,3,6}, {1,4,7}, {2,5,8},
                {0,4,8}, {2,4,6}};
        ArrayList<String> emptySquare = new ArrayList<>();
        public  void computer(){
            if(gameActive ){
                int select  = emptySquare.size();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        // yourMethod();
                    }
                }, 5000);
                int selected  = new Random().nextInt(select);
                String selectedSquare = emptySquare.get(selected);
                switch (selectedSquare){
                    case "0":
                        ImageView imageView1 = findViewById(R.id.imageView0);
                        imageView1.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView1.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "1":
                        ImageView imageView2 = findViewById(R.id.imageView1);
                        imageView2.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView2.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "2":
                        ImageView imageView3 = findViewById(R.id.imageView2);
                        imageView3.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView3.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "3":
                        ImageView imageView4 = findViewById(R.id.imageView3);
                        imageView4.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView4.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "4":
                        ImageView imageView5 = findViewById(R.id.imageView4);
                        imageView5.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView5.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "5":
                        ImageView imageView6 = findViewById(R.id.imageView5);
                        imageView6.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView6.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "6":
                        ImageView imageView7 = findViewById(R.id.imageView6);
                        imageView7.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView7.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "7":
                        ImageView imageView8 = findViewById(R.id.imageView7);
                        imageView8.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView8.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;
                    case "8":
                        ImageView imageView9 = findViewById(R.id.imageView8);
                        imageView9.setImageResource(R.drawable.o);
                        activePlayer = 0;
                        emptySquare.remove(selectedSquare);
                        gameState[Integer.parseInt(selectedSquare)] = activePlayer;
//                        imageView9.animate().translationYBy(1500).rotation(3600).setDuration(300);
                        break;

                }
                check();

            }
        }


        public void playerTap(View view){
            ImageView img = (ImageView) view;

            int tappedImage = Integer.parseInt(img.getTag().toString());
            if(!gameActive){
                gameReset(view);
            }
            if(gameState[tappedImage] == 2 && gameActive && emptySquare.contains(Integer.toString(tappedImage))) {
                gameState[tappedImage] = activePlayer;
                img.setTranslationY(-1000f);
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.x);
                    activePlayer = 1;
                    TextView status = findViewById(R.id.status);
                    status.setText("O's Turn - Tap to play");
                    img.animate().translationYBy(1000f).setDuration(1000);
                    check();

                    computer();
                }


            }



        }
        public void check(){
            for(int[] winPosition: winPositions){
                if(gameState[winPosition[0]] == gameState[winPosition[1]] &&
                        gameState[winPosition[1]] == gameState[winPosition[2]] &&
                        gameState[winPosition[0]]!=2){
                    // Somebody has won! - Find out who!
                    String winnerStr;
                    gameActive = false;
                    if(gameState[winPosition[0]] == 0){
                        winnerStr = "X has won";
                    }
                    else{
                        winnerStr = "O has won";
                    }

                    TextView status = findViewById(R.id.status);
                    status.setText(winnerStr);


                }



            }
        }

        public void gameReset(View view) {
            gameActive = true;
            activePlayer = 0;
            for(int i=0; i<gameState.length; i++){
                gameState[i] = 2;
            }


            TextView status = findViewById(R.id.status);
            status.setText("X's Turn - Tap to play");

        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_computer);
            emptySquare.add("0");
            emptySquare.add("1");
            emptySquare.add("2");
            emptySquare.add("3");
            emptySquare.add("4");
            emptySquare.add("5");
            emptySquare.add("6");
            emptySquare.add("7");
            emptySquare.add("8");
        }
    }

