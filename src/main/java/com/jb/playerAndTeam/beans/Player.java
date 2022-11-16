package com.jb.playerAndTeam.beans;
/*

Hila Gannot
11/16/2022 10:57

*/

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name = "players")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int shirtNumber;

    @Column(nullable = false,length = 40)
    private String firstName;

    @Column(nullable = false,length = 40)
    private String lastName;

    @Column(nullable = false)
    private Date birthday;

    @Column(nullable = false)
    private boolean isForeign;

    @Column(nullable = false)
    private double weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;

    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Team team;
}
