package com.jb.playerAndTeam.clr;
/*

Hila Gannot
11/16/2022 1:08

*/

import com.jb.playerAndTeam.beans.Team;
import com.jb.playerAndTeam.service.AdminService;
import com.jb.playerAndTeam.utils.Print;
import com.jb.playerAndTeam.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component
//@Order(2)
public class AdminServiceTest implements CommandLineRunner {

    @Autowired
    private AdminService adminService;
    
    @Autowired
    private Print print;

    @Override
    public void run(String... args) throws Exception {
        //add team
        Team team = Utils.newTeam();
        print.print("ADD TEAM");
        adminService.addTeam(team);
        adminService.getAllTeams().forEach(System.out::println);
        System.out.println();

        //update team
        team.setName("!!!yabalulu!!!");
        print.print("UPDATE TEAM");
        adminService.updateTeam(team,6);
        adminService.getAllTeams().forEach(System.out::println);
        System.out.println();

        //delete team
        print.print("DELETE TEAM");
        adminService.deleteTeam(1);
        adminService.getAllTeams().forEach(System.out::println);
        System.out.println();


        //get one
        print.print("ONE TEAM");
        System.out.println(adminService.getOneTeam(2));
        System.out.println();

        //youngest
        print.print("YOUNGEST TEAM");
        System.out.println(adminService.theYoungestTeam());
        System.out.println();

        //oldest
        print.print("OLDEST TEAM");
        System.out.println(adminService.theOldestTeam());
        System.out.println();

        //stat with
        print.print("START WITH");
        adminService.findByNameStartingWith("!").forEach(System.out::println);
        System.out.println();

        //end with
        print.print("END WITH");
        adminService.findByFirstnameEndingWith("!").forEach(System.out::println);
        System.out.println();

        //contain
        print.print("CONTAIN");
        adminService.findByFirstnameContaining("l").forEach(System.out::println);
        System.out.println();

        //name order desc
        print.print("NAME ORDER BY DESC");
        adminService.findByNameOrderByNameDesc().forEach(System.out::println);
        System.out.println();

        //name order asc
        print.print("NAME ORDER BY ASC");
        adminService.findByNameOrderByNameAsc().forEach(System.out::println);
        System.out.println();

        //Established Year Order desc
        print.print("ESTABLISHED YEAR ORDER DESC");
        adminService.findByEstablishedYearOrderByEstablishedYearDesc().forEach(System.out::println);
        System.out.println();

        //Established Year Order asc
        print.print("ESTABLISHED YEAR ORDER ASC");
        adminService.findByEstablishedYearOrderByEstablishedYearAsc().forEach(System.out::println);
        System.out.println();
    }
}
