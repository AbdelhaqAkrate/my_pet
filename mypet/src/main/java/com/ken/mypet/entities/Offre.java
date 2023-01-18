package com.ken.mypet.entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "offres")
public class Offre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "duration")
    private Integer duration;
    @Column(name = "price")
    private double price;
    @Column(name = "state")
    private Integer state;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person personOffre;

    @Column(name = "pet_owner")
    private long pet_owner;

    
}
