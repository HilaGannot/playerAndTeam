package com.jb.playerAndTeam.beans;
/*

Hila Gannot
11/16/2022 11:04

*/

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 40)
    private String name;

    @Column(nullable = false)
    private int establishedYear;

    @OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST})
    @Singular
    private List<Player> players;
}
