package com.enkrazh.enkrazh.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "post")
@Data
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "text")
    private String text;

    @Column (name = "type")
    private String type;

    @Column(name = "time", columnDefinition= "TIMESTAMP WITH TIME ZONE")
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;


    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "profile_id",nullable = false)
    @JsonIgnore
    private PlayerProfile player;

    @ManyToOne (fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "discussion",nullable = false)
    @JsonIgnore
    private Discussions discussion;


    public Post(String text, String type, Data time, PlayerProfile player, Discussions discussion) {
        this.text = text;
        this.type = type;
        this.time = (Date) time;
        this.player = player;
        this.discussion = discussion;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public Date getTime() {
        return time;
    }

    public PlayerProfile getPlayer() {
        return player;
    }

    public Discussions getDiscussion() {
        return discussion;
    }
}
