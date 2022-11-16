package com.jb.playerAndTeam.exception;
/*

Hila Gannot
11/16/2022 11:59

*/

public class NBACustomException extends Exception{

    public NBACustomException(ErrBascet errBascet) {
        super(errBascet.name());
    }
}
