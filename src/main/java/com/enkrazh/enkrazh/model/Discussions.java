package com.enkrazh.enkrazh.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "discussion")
@Data
public class Discussions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column (name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    private DiscussionType type;

    @Column (name = "description")
    private String description;

    @Column (name = "tags")
    private String tags;


    @Column (name = "img")
    private String img;

    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<Post> posts;
}
