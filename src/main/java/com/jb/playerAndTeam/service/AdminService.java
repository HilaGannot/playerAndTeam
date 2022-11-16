package com.jb.playerAndTeam.service;

import com.jb.playerAndTeam.beans.Team;
import com.jb.playerAndTeam.exception.NBACustomException;
import com.jb.playerAndTeam.repos.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/*

Hila Gannot
11/16/2022 12:11

*/
@Service
public interface AdminService {

    void addTeam(Team team) throws NBACustomException;
    void updateTeam(Team team, int teamId) throws NBACustomException;
    void deleteTeam(int teamId) throws NBACustomException;
    List<Team> getAllTeams();
    Team getOneTeam(int teamId) throws NBACustomException;
    Team theYoungestTeam() throws NBACustomException;
    Team theOldestTeam() throws NBACustomException;
    List<Team> findByNameStartingWith(String start);
    List<Team> findByFirstnameEndingWith(String end);
    List<Team> findByFirstnameContaining(String contain);
    List<Team> findByNameOrderByNameDesc();
    List<Team> findByNameOrderByNameAsc();
    List<Team> findByEstablishedYearOrderByEstablishedYearDesc();
    List<Team> findByEstablishedYearOrderByEstablishedYearAsc();
}
