package com.example.socialmedia.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long commentId;

    private String comment;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommented;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;


}
