package com.enkrazh.enkrazh.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "character")
@Data
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "fullname")
    private String fullName;

    @Column (name = "age")
    private int age;

    @Column (name = "temper")
    private String temper;

    @Column (name = "img")
    private String img;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "quest",nullable = false)
    @JsonIgnore
    private Profile_Quest quest;

}
