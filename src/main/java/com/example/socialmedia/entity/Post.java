package com.example.socialmedia.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String title;
    @Column(length = 5000)
    private Date dateCreated;
    private Date dateUpdated;
    @Column(length = 5000)
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Comments> commentsList=new ArrayList<>();

}
