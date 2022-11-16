package com.jb.playerAndTeam.repos;

import com.jb.playerAndTeam.beans.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/*

Hila Gannot
11/16/2022 11:07

*/
@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    boolean existsByIdAndTeam_id(int id, int teamId);
    boolean findByBirthdayBefore(Date date);
    List<Player> findByTeam_id(int teamId);
    Player findByTeam_idAndId(int teamId, int id);
    @Query(value = "SELECT * FROM `teamandplayer-151`.players WHERE(team_id=?) AND (birthday= (SELECT MAX(birthday) FROM `teamandplayer-151`.players));", nativeQuery = true)
    Player oldestPlayer(int teamId);

    @Query(value = "SELECT * FROM `teamandplayer-151`.players WHERE(team_id=?) AND (birthday= (SELECT MIN(birthday) FROM `teamandplayer-151`.players));;", nativeQuery = true)
    Player youngestPlayer(int teamId);

    @Query(value = "select avg(shirt_number) from `teamandplayer-151`.players where `team_id`=?;", nativeQuery = true)
    double avgShirtNum(int teamId);

    @Query(value = "select sum(shirt_number) from `teamandplayer-151`.players where `team_id`=?;", nativeQuery = true)
    int sumShirtNum(int teamId);

}
