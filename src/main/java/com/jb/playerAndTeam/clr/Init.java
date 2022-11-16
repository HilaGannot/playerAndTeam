package com.jb.playerAndTeam.clr;
/*

Hila Gannot
11/16/2022 11:08

*/

import com.jb.playerAndTeam.beans.Player;
import com.jb.playerAndTeam.beans.Team;
import com.jb.playerAndTeam.repos.PlayerRepository;
import com.jb.playerAndTeam.repos.TeamRepository;
import com.jb.playerAndTeam.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void run(String... args) throws Exception {
        Team team1 = Utils.newTeam();
        Team team2 = Utils.newTeam();
        Team team3 = Utils.newTeam();
        Team team4 = Utils.newTeam();
        Team team5 = Utils.newTeam();


        teamRepository.saveAll(List.of(team1,team2,team3,team4,team5));

    }
}
