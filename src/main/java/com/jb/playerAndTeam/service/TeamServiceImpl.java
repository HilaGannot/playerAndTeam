package com.jb.playerAndTeam.service;

import com.jb.playerAndTeam.beans.Player;
import com.jb.playerAndTeam.beans.Team;
import com.jb.playerAndTeam.exception.ErrBascet;
import com.jb.playerAndTeam.exception.NBACustomException;
import com.jb.playerAndTeam.repos.PlayerRepository;
import com.jb.playerAndTeam.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/*

Hila Gannot
11/16/2022 3:24

*/
@Service
public class TeamServiceImpl implements TeamService{
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;


    @Override
    public void addPlayer(Player player, int teamID) throws NBACustomException {
        Team myTeam = teamRepository.findById(teamID).orElseThrow(()->new NBACustomException(ErrBascet.NOT_YPUR_TEAM));
        if(playerRepository.existsByIdAndTeam_id(player.getId(),teamID)){
            throw new NBACustomException(ErrBascet.ID_ALREADY_EXIST);
        }
        player.setTeam(myTeam);
        playerRepository.save(player);
    }

    @Override
    public void updatePlayer(int playerId, Player player, int teamID) throws NBACustomException {
        Team myTeam = teamRepository.findById(teamID).orElseThrow(()->new NBACustomException(ErrBascet.NOT_YPUR_TEAM));
        Player playerFromDB = getOnePlayer(playerId,teamID);
        if(!player.getPosition().equals(playerFromDB.getPosition())){
            throw new NBACustomException(ErrBascet.CHANGE_POSITION);
        }
        player.setTeam(myTeam);
        playerRepository.saveAndFlush(player);
    }

    @Override
    public void deletePlayer(int playerId, int teamID) throws NBACustomException {
        Team myTeam = teamRepository.findById(teamID).orElseThrow(()->new NBACustomException(ErrBascet.NOT_YPUR_TEAM));
        Player playerFromDB = getOnePlayer(playerId,teamID);
        if(!playerFromDB.getTeam().equals(myTeam)){
            throw new NBACustomException(ErrBascet.NOT_YPUR_TEAM);
        }
        Date date = Date.valueOf(LocalDate.now().minusYears(35));
        if(playerRepository.findByBirthdayBefore(date)){
            throw new NBACustomException(ErrBascet.OVER_35);
        }
        playerRepository.deleteById(playerId);
    }

    @Override
    public List<Player> getAllPlayer(int teamID) throws NBACustomException {
        return playerRepository.findByTeam_id(teamID);
    }

    @Override
    public Player getOnePlayer(int playerId, int teamID) throws NBACustomException {
        if(playerRepository.existsByIdAndTeam_id(playerId, teamID)){
            throw new NBACustomException(ErrBascet.ID_DOESNT_EXIST);
        }
        return playerRepository.findByTeam_idAndId(teamID, playerId);
    }

    @Override
    public Player nameAndAgeOldest(int teamID) {
        return playerRepository.oldestPlayer(teamID);
    }

    @Override
    public Player nameAndAgeYoungest(int teamID) {
        return playerRepository.youngestPlayer(teamID);
    }

    @Override
    public double avgShirtNum(int teamID) {
        return playerRepository.avgShirtNum(teamID);
    }

    @Override
    public int allShirtNum(int teamID) {
        return playerRepository.sumShirtNum(teamID);
    }
}
