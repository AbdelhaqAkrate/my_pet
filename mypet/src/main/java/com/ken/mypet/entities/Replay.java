package com.ken.mypet.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import jakarta.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "replays")
public class Replay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "replay")
    private String replay;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personReplay;
    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;


}
