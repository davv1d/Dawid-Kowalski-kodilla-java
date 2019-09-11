package com.kodilla.rps.view;

import com.kodilla.rps.judge.Judge;

public class Drawer {
    public void drawResult(String result) {
        if (result.equals(Judge.COMPUTER) || result.equals(Judge.PLAYER)) {
            System.out.println("This game win: " + result);
        } else if (result.equals(Judge.DRAW)) {
            System.out.println("Draw this time");
        } else {
            System.out.println(result);
        }
    }
}
