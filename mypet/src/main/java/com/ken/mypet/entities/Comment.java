package com.ken.mypet.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personComment;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postComment;
    @OneToMany(mappedBy = "comment")
    private List<Replay> replays;
    
}
