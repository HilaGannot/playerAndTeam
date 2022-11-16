package com.jb.playerAndTeam.service;

import com.jb.playerAndTeam.beans.Player;
import com.jb.playerAndTeam.exception.NBACustomException;
import org.springframework.stereotype.Service;

import java.util.List;

/*

Hila Gannot
11/16/2022 3:10

*/
@Service
public interface TeamService {
    void addPlayer(Player player, int teamID) throws NBACustomException;
    void updatePlayer(int playerId, Player player, int teamID) throws NBACustomException;
    void deletePlayer(int playerId, int teamID) throws NBACustomException;
    List<Player> getAllPlayer(int teamID) throws NBACustomException;
    Player getOnePlayer(int playerId, int teamID) throws NBACustomException;
    Player nameAndAgeOldest(int teamID);
    Player nameAndAgeYoungest(int teamID);
    double avgShirtNum(int teamID);
    int allShirtNum(int teamID);
}
