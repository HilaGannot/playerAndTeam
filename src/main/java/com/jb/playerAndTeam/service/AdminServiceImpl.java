package com.jb.playerAndTeam.service;

import com.jb.playerAndTeam.beans.Team;
import com.jb.playerAndTeam.exception.ErrBascet;
import com.jb.playerAndTeam.exception.NBACustomException;
import com.jb.playerAndTeam.repos.PlayerRepository;
import com.jb.playerAndTeam.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*

Hila Gannot
11/16/2022 12:58

*/
@Service
public class AdminServiceImpl implements AdminService {
//    @Autowired
//    private PlayerRepository playerRepository;
    @Autowired
    private TeamRepository teamRepository;

    @Override
    public void addTeam(Team team) throws NBACustomException {
        int teamId = team.getId();
        if(teamRepository.existsById(teamId)){
            throw new NBACustomException(ErrBascet.ID_ALREADY_EXIST);
        }

        if(teamRepository.existsByName(team.getName())){
            throw new NBACustomException(ErrBascet.SAME_MANE);
        }
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team, int teamId) throws NBACustomException {
        if(!teamRepository.existsById(teamId)){
            throw new NBACustomException(ErrBascet.ID_DOESNT_EXIST);
        }
        teamRepository.saveAndFlush(team);
    }

    @Override
    public void deleteTeam(int teamId) throws NBACustomException {
        if(!teamRepository.existsById(teamId)){
            throw new NBACustomException(ErrBascet.ID_DOESNT_EXIST);
        }
        Team team = getOneTeam(teamId);
        if(team.getEstablishedYear()<=1975){
            throw new NBACustomException(ErrBascet.BEFORE_1975);
        }
        teamRepository.deleteById(teamId);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team getOneTeam(int teamId) throws NBACustomException {
        return teamRepository.findById(teamId).orElseThrow(()->new NBACustomException(ErrBascet.ID_DOESNT_EXIST));
    }

    @Override
    public Team theYoungestTeam() throws NBACustomException {
        Team team = teamRepository.theYoungestTeam();
        if(team == null){
            throw new NBACustomException(ErrBascet.NO_TEAMS);
        }
        return team;
    }

    @Override
    public Team theOldestTeam() throws NBACustomException {
        Team team = teamRepository.theOldestTeam();
        if(team == null){
            throw new NBACustomException(ErrBascet.NO_TEAMS);
        }
        return team;
    }

    @Override
    public List<Team> findByNameStartingWith(String start) {
        return teamRepository.findByNameStartingWith(start);
    }

    @Override
    public List<Team> findByFirstnameEndingWith(String end) {
        return teamRepository.findByNameEndingWith(end);
    }

    @Override
    public List<Team> findByFirstnameContaining(String contain) {
        return teamRepository.findByNameContaining(contain);
    }

    @Override
    public List<Team> findByNameOrderByNameDesc() {
        return teamRepository.OrderByNameDesc();
    }

    @Override
    public List<Team> findByNameOrderByNameAsc() {
        return teamRepository.OrderByNameAsc();
    }

    @Override
    public List<Team> findByEstablishedYearOrderByEstablishedYearDesc() {
        return teamRepository.OrderByEstablishedYearDesc();
    }

    @Override
    public List<Team> findByEstablishedYearOrderByEstablishedYearAsc() {
        return teamRepository.OrderByEstablishedYearAsc();
    }
}
