package com.jb.playerAndTeam.clr;

import com.jb.playerAndTeam.beans.Player;
import com.jb.playerAndTeam.beans.Position;
import com.jb.playerAndTeam.service.TeamService;
import com.jb.playerAndTeam.utils.Print;
import com.jb.playerAndTeam.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.sql.Date;
import java.time.LocalDate;

/*

Hila Gannot
11/16/2022 3:54

*/
@Component
@Order(3)
public class TeamServiceTest implements CommandLineRunner {
    @Autowired
    private TeamService teamService;

    @Autowired
    private Print print;

    @Override
    public void run(String... args) throws Exception {

        //add player
        Player player = Player.builder()
                .birthday(Date.valueOf(LocalDate.now().minusYears(20)))
                .isForeign(true)
                .position(Position.randPos())
                .weight(55.5)
                .firstName("aaa")
                .lastName("bbb")
                .shirtNumber(99)
                .build();
        print.print("ADD PLAYER");
        teamService.addPlayer(player,4);

    }
}
