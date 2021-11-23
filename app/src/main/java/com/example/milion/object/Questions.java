package com.example.milion.object;

import java.util.ArrayList;
import java.util.Random;

public class Questions {
   public ObjectGame objectGame(int cap){

       Random r = new Random();
       int s = r.nextInt(100);
       int s2 = r.nextInt(100);

       int t = s + s2;

       String noGame = s + " + " + s2 + " ? "+"("+ cap+")";
       ObjectGame objectGame = new ObjectGame();
       objectGame.setNoGame(noGame);
       objectGame.setGame("" + t);
       ArrayList<String> arrList = new ArrayList<>();

       do{
           int tFace = r.nextInt(200);
           if(tFace != t){
               arrList.add("" + tFace);
           }
       }while (arrList.size() !=3);

       objectGame.setArrDapanSal(arrList);
       return  objectGame;
   }

}
