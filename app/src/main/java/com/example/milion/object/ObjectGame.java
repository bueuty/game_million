package com.example.milion.object;

import java.util.ArrayList;

public class ObjectGame {
    private  String noGame,yesGame;
    private ArrayList<String> arrDapanSal;

    public String getNoDung() {
        return noGame;
    }

    public void setNoGame(String noDung) {
        this.noGame = noDung;
    }

    public String getGame() {
        return yesGame;
    }

    public void setGame(String dupanDung) {
        this.yesGame = dupanDung;
    }

    public ArrayList<String> getArrDapanSal() {
        return arrDapanSal;
    }

    public void setArrDapanSal(ArrayList<String> arrDapanSal) {
        this.arrDapanSal = arrDapanSal;
    }
}
