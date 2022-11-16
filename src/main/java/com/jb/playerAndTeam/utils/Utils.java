package com.jb.playerAndTeam.utils;
/*

Hila Gannot
11/16/2022 11:15

*/

import com.jb.playerAndTeam.beans.Player;
import com.jb.playerAndTeam.beans.Position;
import com.jb.playerAndTeam.beans.Team;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Utils {

    private static int estYear = 1981;
    public static String randName(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        return generatedString;
    }

    public static Team newTeam(){
        int bDay = 22;
        boolean foreign = false;
        double weight = 66.5;
        int sNum = 0;

        Player player1 = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(bDay)))
                .isForeign(foreign)
                .position(Position.randPos())
                .weight(weight)
                .firstName(Utils.randName())
                .lastName(Utils.randName())
                .shirtNumber(sNum)
                .build();
        bDay++;
        foreign = !foreign;
        weight+=1.6;
        sNum++;

        Player player2 = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(bDay)))
                .isForeign(foreign)
                .position(Position.randPos())
                .weight(weight)
                .firstName(Utils.randName())
                .lastName(Utils.randName())
                .shirtNumber(sNum)
                .build();
        bDay++;
        foreign = !foreign;
        weight+=1.6;
        sNum++;

        Player player3 = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(bDay)))
                .isForeign(foreign)
                .position(Position.randPos())
                .weight(weight)
                .firstName(Utils.randName())
                .lastName(Utils.randName())
                .shirtNumber(sNum)
                .build();
        bDay++;
        foreign = !foreign;
        weight+=1.6;
        sNum++;

        Player player4 = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(bDay)))
                .isForeign(foreign)
                .position(Position.randPos())
                .weight(weight)
                .firstName(Utils.randName())
                .lastName(Utils.randName())
                .shirtNumber(sNum)
                .build();
        bDay++;
        foreign = !foreign;
        weight+=1.6;
        sNum++;

        Player player5 = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(bDay)))
                .isForeign(foreign)
                .position(Position.randPos())
                .weight(weight)
                .firstName(Utils.randName())
                .lastName(Utils.randName())
                .shirtNumber(sNum)
                .build();
        bDay++;
        foreign = !foreign;
        weight+=1.6;
        sNum++;

        Team team = Team.builder()
                .establishedYear(estYear)
                .name(randName())
                .players(List.of(player1,player2,player3,player4,player5))
                .build();

        estYear+=11;

        player1.setTeam(team);
        player2.setTeam(team);
        player3.setTeam(team);
        player4.setTeam(team);
        player5.setTeam(team);

        return team;
    }
}
