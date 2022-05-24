package com.enkrazh.enkrazh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "marvos")
@Data
public class Marvos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "quantity")
    private int quantity;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "player", referencedColumnName = "id")
    private PlayerProfile player;
}
