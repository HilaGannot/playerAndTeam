package com.jb.playerAndTeam.repos;

import com.jb.playerAndTeam.beans.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

Hila Gannot
11/16/2022 11:07

*/
@Repository
public interface TeamRepository extends JpaRepository<Team,Integer> {

    @Query(value = "SELECT *FROM `teamandplayer-151`.teams WHERE established_year = ( SELECT MIN(established_year) FROM `teamandplayer-151`.teams) limit 1;", nativeQuery = true)
    Team theYoungestTeam();

    @Query(value = "SELECT *FROM `teamandplayer-151`.teams WHERE established_year = ( SELECT MAX(established_year) FROM `teamandplayer-151`.teams) limit 1;", nativeQuery = true)
    Team theOldestTeam();

    List<Team> findByNameStartingWith(String start);
    List<Team> findByNameEndingWith(String end);
    List<Team> findByNameContaining(String contain);

    List<Team> OrderByNameDesc();
    List<Team> OrderByNameAsc();
    List<Team> OrderByEstablishedYearDesc();

    List<Team> OrderByEstablishedYearAsc();

    boolean existsByName(String name);

}
