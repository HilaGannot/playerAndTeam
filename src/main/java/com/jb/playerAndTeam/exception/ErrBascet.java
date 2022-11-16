package com.jb.playerAndTeam.exception;
/*

Hila Gannot
11/16/2022 12:01

*/

public enum ErrBascet {

    SAME_MANE("can't add team with the same name"),
    UPDATE_ESTABLISHED_YEAR("can't update established year for teams"),
    BEFORE_1975("can't delete team that established before 1975"),
    ID_DOESNT_EXIST("the id doesn't exist"),
    ID_ALREADY_EXIST("the id already exist"),
    NO_TEAMS("no team!!!"),
    NOT_YPUR_TEAM("not your team!!"),
    CHANGE_POSITION("can't change position"),
    OVER_35("can't delete player older then 35");



    private String msg;

    ErrBascet(String msg) {
        this.msg = msg;
    }
}
