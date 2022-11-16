package com.jb.playerAndTeam.utils;
/*

Hila Gannot
11/16/2022 1:06

*/

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Print {

    @Value("${SIZE}")
    private int SIZE;

    public void print(String txt){
        int side = (SIZE - txt.length()) / 2;
        System.out.print("@".repeat(side));
        System.out.print(txt);
        System.out.println("@".repeat(side));
    }
}
