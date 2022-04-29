package com.enkrazh.enkrazh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "login_history")
@Data
public class LoginHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "login_time")
    private Time loginTime;

    @Column (name = "logout_time")
    private Time logoutTime;

    @Column (name = "login_data")
    private String loginData;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "profile_id",nullable = false)
    @JsonIgnore
    private PlayerProfile history;



}
