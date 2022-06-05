package com.enkrazh.enkrazh.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "quest")
@Data
public class Quest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "description")
    private String description;

    @Column (name = "type")
    private String type;

    @Column (name = "tags")
    private String tags;

    @Enumerated(EnumType.STRING)
    private QuestMode mode;

    @OneToMany(mappedBy = "quest")
    private Set<Profile_Quest> playerQuest;
}
