package com.enkrazh.enkrazh.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profile_quest")
@Data
public class Profile_Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "player")
    PlayerProfile player;

    @ManyToOne
    @JoinColumn(name = "quest")
    Quest quest;

    @OneToMany(mappedBy = "quest", cascade = CascadeType.ALL)
    private List<Character> characters;

}
