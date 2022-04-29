package com.enkrazh.enkrazh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "player_profile")
@Data
public class PlayerProfile {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "e_mail" , unique = true)
    private String email;

    @Column (name = "passwd", unique = true)
    private String passwd;

    @Column (name = "username", unique = true)
    private  String username;

    @Column (name = "status_player")
    private String playerStatus;

    @Column (name = "profile_photo")
    private  String profilePhotoLink;

    @Column (name = "is_online")
    private boolean isOnline;

    @OneToMany(mappedBy = "history", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistoryList;

}
