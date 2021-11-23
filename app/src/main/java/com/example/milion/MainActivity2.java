package com.example.milion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.milion.adapter.GameAdapter;
import com.example.milion.object.Questions;
import com.example.milion.object.ObjectGame;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    ListView lstText;
    GameAdapter gameAdapter;
    ArrayList<String> arrGame;
    ObjectGame objectGame;
    String questions;
    int soObjectGame = 1;

    Questions faceData;


    TextView txtView,txtBtn,txtBtn2,txtBtn3,txtBtn4;

    ArrayList<TextView> arrTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        init2();
        setUp();
        setClick();
    }
    public void  init(){
        arrGame = new ArrayList<>();
        arrGame.add("100");
        arrGame.add("200");
        arrGame.add("300");
        arrGame.add("500");
        arrGame.add("1000");
        arrGame.add("2000");
        arrGame.add("4000");
        arrGame.add("8000");
        arrGame.add("16000");


        gameAdapter = new GameAdapter(this,0,arrGame);

        objectGame = new ObjectGame();


        arrTxt = new ArrayList<>();

        faceData = new Questions();
    }
    public void  init2(){
        lstText = findViewById(R.id.lstText);
        txtView = findViewById(R.id.txtView);
        txtBtn = findViewById(R.id.txtBtn);
        txtBtn2 = findViewById(R.id.txtBtn2);
        txtBtn3 = findViewById(R.id.txtBtn3);
        txtBtn4 = findViewById(R.id.txtBtn4);


    arrTxt.add(txtBtn);
        arrTxt.add(txtBtn2);
        arrTxt.add(txtBtn3);
        arrTxt.add(txtBtn4);
    }
    public void  setUp(){

        lstText.setAdapter(gameAdapter);



        GameMillion();
    }

    //private void objectGame() {
   // }

    public void  setClick(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              checkGame(((TextView)view));
            }
        };
      //  txtBtn.setOnClickListener(listener);
       // txtBtn2.setOnClickListener(listener);
      //  txtBtn3.setOnClickListener(listener);
      //  txtBtn4.setOnClickListener(listener);

        for(TextView t:arrTxt){
            t.setOnClickListener(listener);
        }
    }

    public void checkGame(TextView txt){

     questions = txt.getText().toString();

        txt.setBackgroundResource(R.drawable.bg_view);


        new CountDownTimer(2000,100){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

            for(TextView t : arrTxt){
                String s = t.getText().toString();
                if(s.equals(objectGame.getGame())){
                    t.setBackgroundResource(R.drawable.bg_btn);
                    break;
                }
            }
            new CountDownTimer(2000,100){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {

                    if(questions.equals(objectGame.getGame())){
                        soObjectGame++;
                        if(soObjectGame >= 15){
                            soObjectGame = 15;
                        }
                        GameMillion();

                    }else {
                        Toast.makeText( MainActivity2.this,"",Toast.LENGTH_SHORT).show();
                    }
                }
            }.start();
            }
        }.start();

     //   if(questions.equals(objectGame.getDupanDung())){
       //     soObjectGame++;
       //     if(soObjectGame >= 15){
       //         soObjectGame = 15;
       //     }
       //     GameMillion();

       // }else {
     //       Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
       // }

    }


    public  void objectGame(){

     objectGame = faceData.objectGame(soObjectGame);
    }
    public void GameMillion(){
        objectGame();
    txtView.setText(objectGame.getNoDung());
    ArrayList<String> arrGame = new ArrayList<>(objectGame.getArrDapanSal());
    arrGame.add(objectGame.getGame());


        Random r = new Random();

        for(int i = 0; i < 5; i++){
            int vt1 = r.nextInt(arrGame.size());
            int vt2 =r.nextInt(arrGame.size());
          String a = arrGame.get(vt1);
          arrGame.set(vt1,arrGame.get(vt2));
          arrGame.set(vt2,a);
        }


        for(int i=0;i< arrTxt.size();i++){
            arrTxt.get(i).setBackgroundResource(R.drawable.bg_view);
            arrTxt.get(i).setText(arrGame.get(i));
        }

       // txtBtn.setText(arrGame.get(0));
      //  txtBtn2.setText(arrGame.get(1));
      //  txtBtn3.setText(arrGame.get(2));
      //  txtBtn4.setText(arrGame.get(3));

        gameAdapter.setViObjectGame(soObjectGame);
    }
}