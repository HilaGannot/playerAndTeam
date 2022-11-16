package com.jb.playerAndTeam.beans;
/*

Hila Gannot
11/16/2022 10:55

*/

public enum Position {
    PG("point guard"),

    SG("shooting guard"),

    SF("small forward"),

    PF("power forward"),

    C("center");

    private String txt;

    Position(String txt) {
        this.txt = txt;
    }

    public static Position randPos(){
        int rand = (int) (Math.random()*Position.values().length);
        return Position.values()[rand];
    }
}
