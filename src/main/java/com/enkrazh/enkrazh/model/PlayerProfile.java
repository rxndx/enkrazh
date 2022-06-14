package com.enkrazh.enkrazh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "player_profile")
@Data
public class PlayerProfile {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "e_mail" , unique = true)
    private String email;

    @Column (name = "passwd")
    private String passwd;

    @Transient
    private String confirmPassword;

    @Column (name = "username", unique = true)
    private  String username;

    @Enumerated(EnumType.STRING)
    private PlayerRole role;

    @Column (name = "profile_photo")
    private  String profilePhotoLink;

    @Column (name = "mavros")
    private int marvos;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<LoginHistory> loginHistoryList;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(mappedBy = "player")
    private Set<Profile_Quest> playerQuest;

}
